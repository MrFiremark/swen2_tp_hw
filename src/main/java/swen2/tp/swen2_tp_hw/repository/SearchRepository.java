package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.model.SearchResult;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SearchRepository extends Repository{

    public ArrayList<SearchResult> getSearchResult(String searchString) throws SQLException, IOException {

        try (
                Connection connection = getConnection();
                PreparedStatement statement1 = connection.prepareStatement(
                        "SELECT " +
                            "id, name, description, startpoint, endpoint " +
                            "   FROM tour_data " +
                            "           WHERE " +
                            "               lower(name) like ? OR " +
                            "               lower(description) like ? OR " +
                            "               lower(startpoint) like ? OR " +
                                "           lower(endpoint) like ? ;"
                );

                PreparedStatement statement2 = connection.prepareStatement(
                        "SELECT " +
                                "id, name, description, startpoint, endpoint ,logid, comment, difficulty " +
                                "   FROM tour_data " +
                                "   JOIN tourlog_data " +
                                "       ON tour_data.id=tourlog_data.tourid " +
                                "           WHERE " +
                                "               lower(comment) like ? OR " +
                                "               lower(difficulty) like ? ;"

                );
        ) {

            ArrayList<SearchResult> searchResult = new ArrayList<>();

            searchString = "%"+searchString.toLowerCase(Locale.ROOT)+"%";
            statement1.setString(1, searchString);
            statement1.setString(2, searchString);
            statement1.setString(3, searchString);
            statement1.setString(4, searchString);

            statement2.setString(1, searchString);
            statement2.setString(2, searchString);

            ResultSet resultSet1 = statement1.executeQuery();

            if(resultSet1 != null){
                while (resultSet1.next()) {
                    searchResult.add(
                            new SearchResult(
                                "Tour",
                                    resultSet1.getString("id"),
                                    "",
                                    resultSet1.getString("name"),
                                    resultSet1.getString("description"),
                                    resultSet1.getString("startpoint"),
                                    resultSet1.getString("endpoint"),
                                    "",
                                    ""
                            )
                    );
                }
            }else {
                ResultSet resultSet2 = statement2.executeQuery();

                while (resultSet2.next()) {
                    searchResult.add(
                            new SearchResult(
                                "Tourlog",
                                resultSet2.getString("id"),
                                resultSet2.getString("logid"),
                                resultSet2.getString("name"),
                                resultSet2.getString("description"),
                                resultSet2.getString("startpoint"),
                                resultSet2.getString("endpoint"),
                                resultSet2.getString("comment"),
                                resultSet2.getString("difficulty")
                            )
                    );
                }
            }

            return searchResult;
        }
    }
}
