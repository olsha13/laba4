package com.TestOfTables;

import com.Connection.JDBC;

import java.sql.*;
import java.util.*;
public class GetAllRows {
    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM Authors";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block, used to close resources
            JDBC.close();
        }
    }

}
