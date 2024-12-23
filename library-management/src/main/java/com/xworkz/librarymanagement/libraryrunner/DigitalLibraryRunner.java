package com.xworkz.librarymanagement.libraryrunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DigitalLibraryRunner {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver found");
            String url="jdbc:mysql://localhost:3306/LIBRARYMANAGEMENT";
            String user="root";
            String password="p00jitha@S";
            connection=DriverManager.getConnection(url,user,password);
            System.out.println("Connection Established");

            String insert1 = "insert into digital_library( book_name, book_author) values ('Computer Vision: Algorithms', 'Richard Szeliski')";

            String insert2 = "insert into digital_library(book_name, book_author) values ('Machine Learning', 'Andrew Ng and Michael ')";

            String insert3 = "insert into digital_library(book_name, book_author) values ('Web Development', 'Chris and Eva Holland')";

            String insert4 = "insert into digital_library( book_name, book_author) values ('Cybersecurity 101', 'Mark Stanislav')";

            String insert5 = "insert into digital_library(book_name, book_author) values ('Artificial Intelligence', 'Stuart and Peter Norvig')";

            String insert6="insert into digital_library(book_name,book_author)values('Intro to CS','Robert & Kevin Wayne')";

            String insert7="insert into digital_library(book_name,book_author)values('DSA','John E. Hopcroft')";

            String insert8="insert into digital_library(book_name,book_author)values('Computer Networks','Andrew and David')";

            String insert9="insert into digital_library(book_name,book_author)values('Database Systems','Hector Garcia-Molina')";

            String insert10="insert into digital_library(book_name,book_author)values('Operating System','Abraham Silberschatz')";
            Statement statement=connection.createStatement();
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);
            statement.addBatch(insert6);
            statement.addBatch(insert7);
            statement.addBatch(insert8);
            statement.addBatch(insert9);
            statement.addBatch(insert10);
            int[] rows= statement.executeBatch();
            System.out.println(rows.length+" rows inserted");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("JDBC Driver not found"+e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

