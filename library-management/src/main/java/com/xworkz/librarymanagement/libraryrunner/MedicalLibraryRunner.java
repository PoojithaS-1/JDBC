package com.xworkz.librarymanagement.libraryrunner;
import java.sql.*;
public class MedicalLibraryRunner {
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
            String insert1 = "insert into medical_library( book_name, book_author) values ('Harrison Principles of Internal Medicine', 'Dennis L. Kasper and Anthony S. Fauci')";

            String insert2 = "insert into medical_library( book_name, book_author) values ('Gray Anatomy', 'Henry Gray and Susan Standring')";

            String insert3 = "insert into medical_library(book_name, book_author) values ('Pharmacology for Nurses', 'Hilary Lloyd and Stephen G. Barrie')";

            String insert4 = "insert into medical_library( book_name, book_author) values ( 'Robbins Pathologic Basis of Disease', 'Vinay Kumar and Nelson Fausto')";

            String insert5 = "insert into medical_library(book_name, book_author) values ('Guyton Textbook of Medical Physiology', 'John E. Hall and Arthur C. Guyton')";

            Statement statement=connection.createStatement();
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);

            int[] rows=statement.executeBatch();
            System.out.println(rows.length+" rows inserted Successfully!");

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
