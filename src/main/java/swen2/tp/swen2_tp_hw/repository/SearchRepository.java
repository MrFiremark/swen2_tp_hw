package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.model.Tour;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SearchRepository extends Repository{

    public ArrayList<String> getSearchResult(String searchString) throws SQLException, IOException {

        try (
                Connection connection = getConnection();
                PreparedStatement statement1 = connection.prepareStatement(
                        "SELECT " +
                            "name, description, startpooint, endpoint" +
                            "   FROM tour_data" +
                            "           WHERE" +
                            "               name like '%'?'%' OR" +
                            "               description like '%'?'%' OR" +
                            "               startpooint like '%'?'%' OR" +
                                "           endpoint like '%'?'%';"
                );

                PreparedStatement statement2 = connection.prepareStatement(
                        "SELECT " +
                                "comment, difficulty" +
                                "   FROM tour_data" +
                                "   JOIN log_data" +
                                "       ON tour_data.id=lod_data.tourid" +
                                "           WHERE" +
                                "               comment like '%'?'%' OR" +
                                "               difficulty like '%'?'%';"

                );
        ) {

            statement1.setString(1, searchString);
            statement1.setString(2, searchString);
            statement1.setString(3, searchString);
            statement1.setString(4, searchString);

            ResultSet resultSet1 = statement1.executeQuery();

            ArrayList<String> resultList = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();

            if(resultSet1.next()){
                while (resultSet1.next()) {
                    stringBuilder.append("Tourname: " + resultSet1.getString("name"));
                    //TODO BUILD FINISHED STRING
                    resultList.add(stringBuilder.toString());
                }
            }else {
                ResultSet resultSet2 = statement2.executeQuery();

                while (resultSet2.next()) {
                    stringBuilder.append("Tourname: " + resultSet1.getString("name"));
                    //TODO BUILD FINISHED STRING
                    resultList.add(stringBuilder.toString());
                }
            }

            return resultList;
        }
    }
}
