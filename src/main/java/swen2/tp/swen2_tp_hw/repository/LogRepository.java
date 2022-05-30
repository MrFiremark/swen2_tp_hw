package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LogRepository extends Repository{

    private ILoggerWrapper logger = LoggerFactory.getLogger();

    public void addTourLog(TourLog tourLog){

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO tourlog_data (tourid, logid, date, time, comment, difficulty, totaltime, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?);"
                )
        ) {

            statement.setString(1, tourLog.getTourId());
            statement.setString(2, tourLog.getLogid());
            statement.setString(3, tourLog.getDate());
            statement.setObject(4, tourLog.getTime());
            statement.setString(5, tourLog.getComment());
            statement.setString(6, tourLog.getDifficulty());
            statement.setString(7, tourLog.getTotalTime());
            statement.setInt(8, Integer.parseInt(tourLog.getRating()));

            statement.execute();


        }catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL error[err:5440]. " + e);
        }catch (NullPointerException ex){
            ex.printStackTrace();
            logger.error("SQL error[err:5441]. " + ex);
        } catch(Exception ex){
            ex.printStackTrace();
            logger.error("SQL error[err:5442]. " + ex);
        }
    }

    public Tour getTourLog(Tour tour){

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT tourid, logid, date, time, comment, difficulty, totaltime, rating FROM tourlog_data WHERE tourid = ?"
                );
        ) {

            statement.setString(1, tour.getid());
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                tour.addTourLog(
                        new TourLog(
                            resultSet.getString("tourid"),
                            resultSet.getString("logid"),
                            resultSet.getString("date"),
                            resultSet.getString("time"),
                            resultSet.getString("comment"),
                            resultSet.getString("difficulty"),
                            resultSet.getString("totaltime"),
                            String.valueOf(resultSet.getInt("rating"))
                        )
                );
            }

            return tour;

        }catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL error[err:5450]. " + e);
        }catch (NullPointerException ex){
            ex.printStackTrace();
            logger.error("SQL error[err:5451]. " + ex);
        } catch(Exception ex){
            ex.printStackTrace();
            logger.error("SQL error[err:5452]. " + ex);
        }

        return null;
    }

    public void deleteTourLog(String logid) {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM tourlog_data WHERE logid = ?;"
                )
        ) {

            statement.setObject(1, logid);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTourLog(TourLog tourLog){

        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE tourlog_data " +
                                "SET date=?, time=?, comment=?, difficulty=?, totaltime=?, rating=? " +
                                "WHERE logid=?;"
                )
        ) {

            statement.setString(7, tourLog.getLogid());
            statement.setString(1, tourLog.getDate());
            statement.setObject(2, tourLog.getTime());
            statement.setString(3, tourLog.getComment());
            statement.setString(4, tourLog.getDifficulty());
            statement.setString(5, tourLog.getTotalTime());
            statement.setInt(6, Integer.parseInt(tourLog.getRating()));

            statement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL error[err:5460]. " + e);
        }catch (NullPointerException ex){
            ex.printStackTrace();
            logger.error("SQL error[err:5461]. " + ex);
        } catch(Exception ex){
            ex.printStackTrace();
            logger.error("SQL error[err:5462]. " + ex);
        }
    }

}
