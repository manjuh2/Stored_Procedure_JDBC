package com.stored_proceduree;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProcedureApplication {

    public static void main(String[] args) throws SQLException {
//		System.out.println("Hello");
        //SpringApplication.run(StoredProcedureApplication.class, args);

//        callProcedure();

        callAllUsers();

//        insertNewUser();
    }

    public static void callProcedure() throws SQLException {
        Connection connection = ConnectionProvider.getConnection();
        CallableStatement statement = connection.prepareCall("CALL GetUserById(?)");
        statement.setString(1, "2");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " +
                    resultSet.getString((3)) + " " + resultSet.getString(4));
        }
    }

    private static void callAllUsers() throws SQLException {
        Connection connection = ConnectionProvider.getConnection();
        CallableStatement statement = connection.prepareCall("CALL GetAllUsers()");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " "
                    + resultSet.getString(3) + " " + resultSet.getString(4));
        }
    }

    private static void insertNewUser() throws SQLException {
        Connection connection = ConnectionProvider.getConnection();

        CallableStatement statement = connection.prepareCall("CALL insert_users(?,?,?)");

        statement.setString(1, "Chirag");
        statement.setString(2, "Jain");
        statement.setString(3, "Gulbarga");

        statement.execute();
    }

}
