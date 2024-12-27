package com.xworkz.libsystem.retriver.dao;
import  java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ThingsDaoImpl implements ThingsDao{
    @Override
    public int save(String things_name, String brand, String color) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String url = "jdbc:mysql://localhost:3306/LIBRARYMANAGEMENT";
        String user = "root";
        String password = "p00jitha@S";
        try {
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement= connection.prepareStatement("insert into things values(?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,things_name);
            preparedStatement.setString(3,brand);
            preparedStatement.setString(4,color);
            int row=preparedStatement.executeUpdate();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }if (preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
