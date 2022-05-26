package swen2.tp.swen2_tp_hw.repository;

import swen2.tp.swen2_tp_hw.service.ConfigService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Repository {

    private ConfigService configService = new ConfigService();

    protected Connection getConnection() throws SQLException, IOException {

        Connection connection = DriverManager.getConnection(
                configService.load("db.url"),
                configService.load("db.user"),
                configService.load("db.pw")
        );

        return connection;
    }
}
