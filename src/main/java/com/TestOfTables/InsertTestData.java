package com.TestOfTables;
import com.Connection.JDBC;

import java.sql.*;
import java.util.*;
public class InsertTestData {
    public static void main(String[] argv) throws SQLException {
        updateTables();
    }
    public static void updateTables() throws SQLException {
        try{
            JDBC.connect();
            Statement stmt = JDBC.connection.createStatement();
            updateAuthorsTable(stmt);
            updateAuthorIsbnTable(stmt);
            updateTitlesTable(stmt);
            updatePublishersTable(stmt);
        } catch (SQLException e){
            System.out.println("connection failed");
            e.printStackTrace();
            return;
        }
        JDBC.close();
    }
    private static void updateAuthorsTable(Statement stmt) {
        String authorFirstNames[] = { "Jane", "Dan", "Ralph Waldo", "F.Scott","John", "Ernest", "Walter", "Stephen", "Stieg",
                "George", "Joanne K.", "John", "John R. R.", "Kurt", "Andy" };
        String authorLastNames[] = { "Austen", "Brown", "Emerson", "Firtzgerald", "Grisham", "Hemingway", "Isaacson",
                "King", "Larsson", "Orwell", "Rowling", "Steinbeck", "Tolkien", "Vonnegut", "Weir" };
        // reset the auto increment
        String updateAuthorsTable = "ALTER TABLE Authors AUTO_INCREMENT = 1";
        try {
            stmt.executeUpdate(updateAuthorsTable);
        } catch (SQLException e) {
            System.out.println("Execute Update Failed!");
            e.printStackTrace();
            return;
        }
        for (int i = 1; i <= authorFirstNames.length; i++) {
            updateAuthorsTable = "INSERT INTO Authors (firstName, lastName)" + "VALUES ('" + authorFirstNames[i - 1]
                    + "', '" + authorLastNames[i - 1] + "');";
            try {
                stmt.executeUpdate(updateAuthorsTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

    private static void updateAuthorIsbnTable(Statement stmt) {
        String isbn[] = { "0141439519", "0307474278", "0142437629", "0743273565", "0345543240", "0684801223",
                "1501127625", "1501175466", "0307949486", "0451524935", "0439708180", "0142000687", "0547928227",
                "0385333849", "0553418026" };
        for (int i = 1; i <= isbn.length; i++) {
            String updateAuthorISBNTable = "INSERT INTO authorISBN (authorID, isbn)" + "VALUES (" + i + ", '"
                    + isbn[i - 1] + "')";
            try {
                stmt.executeUpdate(updateAuthorISBNTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

    private static void updateTitlesTable(Statement stmt) {
        String isbn[] = { //"0141439519", "0307474278", "0142437629", "0743273565", "0345543240", "0684801223",
               // "1501127625", "1501175466", "0307949486", "0451524935", "0439708180", "0142000687", "0547928227",
               // "0385333849", "0553418026"
        };
        String editionNumber[] = { "10", "10", "8", "4", "5", "7", "3", "14", "5", "3", "1", "18", "12", "2", "3" };
        String year[] = { "2002", "2009", "2003", "2004", "2014", "1995", "2015", "2017", "2011", "1961", "1999",
                "2002", "2012", "1999", "2014" };
        String publisherID[] = { "1", "2", "1", "3", "4", "3", "5", "3", "6", "7", "8", "1", "9", "10", "11" };
        String price[] = { "8.00", "8.99", "13.58", "6.99", "8.49", "9.98", "11.99", "9.55", "8.60", "7.64", "7.47",
                "13.60", "11.16", "12.51", "10.76" };
        String title[] = { "Pride and Prejudice", "The Da Vinci Code", "Nature and Selected Essays", "The Great Gatsby",
                "Sycamore Row", "The Old Man and The Sea", "Steve Jobs", "It: A Novel",
                "The Girl with the Dragon Tattoo", "1984", "Harry Potter and the Sorcerer''s Stone", "Cannery Row",
                "The Hobbit", "Slaughterhouse-Five", "The Martian" };

        for (int i = 0; i < isbn.length; i++) {
            String updateTitlesTable = "INSERT INTO Titles (isbn, title, editionNumber, year, publisherID, price)"
                    + "VALUES ('" + isbn[i] + "', '" + title[i] + "', " + editionNumber[i] + ",'" + year[i] + "',"
                    + publisherID[i] + "," + price[i] + ")";
            try {
                stmt.executeUpdate(updateTitlesTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

    private static void updatePublishersTable(Statement stmt) {
        String publishers[] = { "Penguin", "Anchor", "Scribner", "Dell Books", "Simon & Schuster", "Vintage Crime",
                "Signet", "Scholastic", "Houghton Mifflin", "Dial Press", "Broadway" };
        // reset the auto increment
        String updatePublishersTable = "ALTER TABLE Publishers AUTO_INCREMENT = 1";
        try {
            stmt.executeUpdate(updatePublishersTable);
        } catch (SQLException e) {
            System.out.println("Execute Update Failed!");
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < publishers.length; i++) {
            updatePublishersTable = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + publishers[i] + "')";
            try {
                stmt.executeUpdate(updatePublishersTable);
            } catch (SQLException e) {
                System.out.println("Execute Update Failed!");
                e.printStackTrace();
                return;
            }
        }
    }

}
