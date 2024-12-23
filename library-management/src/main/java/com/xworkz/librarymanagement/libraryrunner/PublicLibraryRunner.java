package com.xworkz.librarymanagement.libraryrunner;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PublicLibraryRunner {
        public static void main(String[] args) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("JDBC Driver found");
                String url="jdbc:mysql://localhost:3306/LIBRARYMANAGEMENT";
                String user="root";
                String password="p00jitha@S";
                DriverManager.getConnection(url,user,password);
                System.out.println("Connection Established");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("JDBC Driver not found"+e.getMessage());
            }
        }

}
