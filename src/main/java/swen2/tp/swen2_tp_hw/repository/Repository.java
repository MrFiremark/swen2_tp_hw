package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.service.ConfigService;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Repository {

    private ILoggerWrapper logger = LoggerFactory.getLogger();
    private ConfigService configService = new ConfigService();

    protected Connection getConnection(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    configService.load("db.url"),
                    configService.load("db.user"),
                    configService.load("db.pw")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("SQL error[err:5401]. Error creating connection to database.");
        } catch(Exception ex){
            ex.printStackTrace();
            logger.error("SQL error[err:5402]. " + ex);
        }

        return connection;
    }
}
