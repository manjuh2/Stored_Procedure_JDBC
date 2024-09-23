package com.stored_proceduree;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stored_procedure", "root", "Manju@2341");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
