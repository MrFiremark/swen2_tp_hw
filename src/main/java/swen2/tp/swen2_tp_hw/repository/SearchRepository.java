package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.model.Tour;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SearchRepository extends Repository{

    public ArrayList<String> getSearchResult(String searchString) throws SQLException, IOException {

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT " +
                            "id, name, description, comment " +
                            "   FROM tour_data" +
                            "   JOIN log_data" +
                            "       ON tour_data.id=lod_data.tourid" +
                            "           WHERE" +
                            "               name like '%'?'%' OR" +
                            "               description like '%'?'%' OR" +
                            "               comment like '%'?'%' OR" +
                                "           from like '%'?'%' OR" +
                                "           to like '%'?'%' OR"
                );
        ) {

            statement.setString(1, searchString);
            statement.setString(2, searchString);
            statement.setString(3, searchString);
            statement.setString(4, searchString);
            statement.setString(5, searchString);

            ResultSet resultSet = statement.executeQuery();

            ArrayList<String> resultList = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();

            while (resultSet.next()) {
                stringBuilder.append("Tourname: " + resultSet.getString("name"));
                //TODO BUILD FINISHED STRING
                resultList.add(stringBuilder.toString());
            }

            return resultList;
        }
    }
}
