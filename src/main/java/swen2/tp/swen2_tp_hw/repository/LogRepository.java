package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LogRepository extends Repository{

    public void addTour(TourLog tourLog){

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO log_data (tourid, logid, datetime, comment, difficulty, totaltime, rating) VALUES (?, ?, ?, ?, ?, ?, ?);"
                )
        ) {

            statement.setString(1, tourLog.getTourId());
            statement.setString(2, tourLog.getLogId());
            statement.setObject(3, tourLog.getDateTime());
            statement.setString(4, tourLog.getComment());
            statement.setString(5, tourLog.getDifficulty());
            statement.setString(6, tourLog.getTotalTime());
            statement.setString(7, tourLog.getRating());

            statement.execute();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    public Tour getTours(Tour tour){

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT tourid, logid, datetime, comment, difficulty, totaltime, rating FROM log_data WHERE tourid = ?"
                );
        ) {


            statement.setString(1, tour.getid());
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                tour.addTourLog(new TourLog(
                        resultSet.getString("tourid"),
                        resultSet.getString("logid"),
                        resultSet.getString("datetime"),
                        resultSet.getString("comment"),
                        resultSet.getString("difficulty"),
                        resultSet.getString("totaltime"),
                        resultSet.getString("rating")
                ));

            }

            return tour;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteTour(String logid) {

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM log_data WHERE logid = ?;"
                )
        ) {

            statement.setObject(1, logid);
            //statement.setString(2, tour.getName());

            statement.execute();


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
