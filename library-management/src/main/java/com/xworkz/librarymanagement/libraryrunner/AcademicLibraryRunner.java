package com.xworkz.librarymanagement.libraryrunner;
import java.sql.*;
public class AcademicLibraryRunner {
    public static void main(String[] args) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("JDBC Driver found");
                String url = "jdbc:mysql://localhost:3306/LIBRARYMANAGEMENT";
                String user = "root";
                String password = "p00jitha@S";
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Established");
                String insert1 = "insert into academic_library(book_id,book_name,book_author)values(12345,'Intro to CS','Robert & Kevin Wayne')";
                String insert2 = "insert into academic_library(book_id,book_name,book_author)values(67890,'DSA','John E. Hopcroft')";
                String insert3 = "insert into academic_library(book_id,book_name,book_author)values(34567,'Computer Networks','Andrew and David')";
                String insert4 = "insert into academic_library(book_id,book_name,book_author)values(90123,'Database Systems','Hector Garcia-Molina')";
                String insert5 = "insert into academic_library(book_id,book_name,book_author)values(45678,'Operating System','Abraham Silberschatz')";
                Statement statement = connection.createStatement();
                statement.addBatch(insert1);
                statement.addBatch(insert2);
                statement.addBatch(insert3);
                statement.addBatch(insert4);
                statement.addBatch(insert5);
                int[] rows = statement.executeBatch();
                System.out.println(rows.length + " rows inserted");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("JDBC Driver not found" + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
}
