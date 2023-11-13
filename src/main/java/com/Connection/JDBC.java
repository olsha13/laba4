package com.Connection;
import java.util.*;
import java.sql.*;
public class JDBC {
    public static Connection connection = null;
    public static void connect() throws SQLException{
        try{
            Class.forName("java.sql.Driver");
            System.out.println("MySql JDBC driver registered");
        } catch (ClassNotFoundException e){
            System.out.println("Where is your mysql jdbc driver?");
            e.printStackTrace();
            throw new SQLException();
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "13032004");
        if(connection == null) {
            throw new SQLException();
        } else {
            System.out.println("Successfully connect");
        }
    }
    public static void close() {
        try {
            if(connection != null) {
                connection.close();
                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
        }
    }
}
