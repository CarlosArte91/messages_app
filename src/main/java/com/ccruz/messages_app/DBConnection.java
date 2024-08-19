package com.ccruz.messages_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlos_cruz
 */
public class DBConnection {

    public Connection getConnection() {
        Connection connection = null;
        final String BASE = "jdbc:mysql://127.0.0.1:3306/";
        final String DB_NAME = "messages_app";
        final String DB_USER = "root";
        final String DB_PASSWORD = "aDMin_8x954j-95";
        final String TIMEZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String URL = BASE + DB_NAME + TIMEZONE;

        try {
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
