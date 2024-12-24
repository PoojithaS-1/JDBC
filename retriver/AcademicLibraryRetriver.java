package com.xworkz.librarymanagement.libraryrunner.retriver;

import java.sql.*;

public class AcademicLibraryRetriver {
        public static void main(String[] args) {
            Connection connection = null;
            Statement statement = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("JDBC Driver found");
                String url = "jdbc:mysql://localhost:3306/LIBRARYMANAGEMENT";
                String user = "root";
                String password = "p00jitha@S";
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Established");
                String query1 = "select * from academic_library";
                String query2 = "select * from academic_library where book_id=12345";
                String query3 = "select * from academic_library where book_id=34567 and book_name='Computer Networks'";
                String query4 ="select * from academic_library where book_name='DSA'";
                statement=connection.createStatement();
                System.out.println();
                System.out.println("Retriving all data from table: ");
                ResultSet resultSet1 = statement.executeQuery(query1);
                while (resultSet1.next()) {
                    System.out.println("BookId: " + resultSet1.getInt(1) + "   BookName: " + resultSet1.getString(2) + "   BookAuthor: " + resultSet1.getString(3));

                }
                System.out.println();
                System.out.println("Fetching Book by Id: ");
                ResultSet resultSet2 = statement.executeQuery(query2);
                while (resultSet2.next()) {
                    System.out.println("BookId: " + resultSet2.getInt(1) + "   BookName: " + resultSet2.getString(2) + "   BookAuthor: " + resultSet2.getString(3));
                }
                System.out.println();
                System.out.println("Fetch Book info using 2 fields: ");
                ResultSet resultSet3 =statement.executeQuery(query3);
                while (resultSet3.next()) {
                    System.out.println("BookId: " + resultSet3.getInt(1) + "   BookName: " + resultSet3.getString(2) + "   BookAuthor: " + resultSet3.getString(3));
                }
                System.out.println();
                System.out.println("Fetching Book by BookName: ");
                ResultSet resultSet4 =statement.executeQuery(query4);
                while (resultSet4.next()){
                    System.out.println("BookId: " + resultSet4.getInt(1) + "   BookName: " + resultSet4.getString(2) + "   BookAuthor: " + resultSet4.getString(3));
                }


            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("JDBC Driver not found" + e.getMessage());
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


