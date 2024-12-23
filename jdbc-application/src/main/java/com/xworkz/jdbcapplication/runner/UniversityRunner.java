package com.xworkz.jdbcapplication.runner;
import java.sql.*;
public class UniversityRunner {
    public static void main(String[] args) {
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Found");
            String url="jdbc:mysql://localhost:3306/COUNTRY";
            String userName="root";
            String password="p00jitha@S";
            connection=DriverManager.getConnection(url,userName,password);
            System.out.println("Connection Established");
            String insert="insert into COUNTRY_INFO(COUNTRY_NAME,COUNTRY_CAPITAL) values('Russia','Moscow')";
            String insert1="insert into COUNTRY_INFO(COUNTRY_NAME,COUNTRY_CAPITAL) values('Srilanka','Colombo')";
            String insert2="insert into COUNTRY_INFO(COUNTRY_NAME,COUNTRY_CAPITAL) values('USA','DC')";
            Statement statement=connection.createStatement();
//            int row=statement.executeUpdate(insert);//insert single record

            statement.addBatch(insert1);// insert multiple records
            statement.addBatch(insert2);

            int[] row=statement.executeBatch();
            System.out.println(row.length+" Row inserted");
        } catch (ClassNotFoundException | SQLException classNotFoundException){
            System.out.println("JDBC Driver not found"+classNotFoundException.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
