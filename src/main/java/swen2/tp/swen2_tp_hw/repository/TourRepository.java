package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.model.Tour;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class TourRepository extends Repository{

    public void addTour(Tour tour){

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO tour_data (id, name, description, transporttype, distance, traveltime, startpoint, endpoint, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"
                )
        ) {

            statement.setObject(1, tour.getid());
            statement.setString(2, tour.getName());
            statement.setString(3, tour.getDescription());
            statement.setString(4, tour.getTransportType());
            statement.setDouble(5, tour.getDistance());
            statement.setString(6, tour.getTime());
            statement.setString(7, tour.getFrom());
            statement.setString(8, tour.getTo());
            statement.setString(9, tour.getImagePath());

            statement.execute();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    public Map<String, Tour> getTours(){

        Map<String, Tour> map = new HashMap<>();

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT " +
                                "id, name, description, transporttype, distance, traveltime, startpoint, endpoint, imagepath " +
                                "FROM tour_data "
                );
        ) {

            ResultSet resultSet = statement.executeQuery();

            Tour tour = null;

            while(resultSet.next()){
                 tour = new Tour(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("startpoint"),
                        resultSet.getString("endpoint"),
                        resultSet.getString("transporttype"),
                        resultSet.getDouble("distance"),
                        resultSet.getString("traveltime"),
                        resultSet.getString("imagepath")
                );
                 map.put(tour.getid(), tour);
            }

            return map;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteTour(String id) {

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM tour_data WHERE id = ?;"
                )
        ) {

            statement.setObject(1, id);
            //statement.setString(2, tour.getName());

            statement.execute();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
