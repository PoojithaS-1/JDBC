package com.xworkz.ecommerceapp.dao;
import java.sql.*;
public class LaptopDaoImpl implements LaptopDao {
    final String URL = "jdbc:mysql://localhost:3306/ECOMMERCEAPP";
    final String USER = "root";
    final String PASSWORD = "p00jitha@S";
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Override
    public int save(String brand, String model, String processor, String ram, String price) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Found");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Established");
            preparedStatement = connection.prepareStatement("insert into laptop_info values(?,?,?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, brand);
            preparedStatement.setString(3, model);
            preparedStatement.setString(4, processor);
            preparedStatement.setString(5, ram);
            preparedStatement.setString(6, price);
            int row = preparedStatement.executeUpdate();
            return row;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public ResultSet getAllData() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("select * from laptop_info");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByIdAndBrand(int laptop_id, String brand) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from laptop_info where laptop_id=? and brand=?");
            preparedStatement.setInt(1, laptop_id);
            preparedStatement.setString(2, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(true);
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
            return null;
        }

    }

    @Override
    public ResultSet getByprocessorAndBrand(String processor, String brand) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from laptop_info where processor=? and brand=?");
            preparedStatement.setString(1, processor);
            preparedStatement.setString(2, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(true);
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
            return null;
        }

    }

    @Override
    public ResultSet getByRamAndId(String ram, int laptop_id) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from laptop_info where ram=? or laptop_id=? ");
            preparedStatement.setString(1, ram);
            preparedStatement.setInt(2,laptop_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(true);
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public int updateByLaptop_id(int laptop_id, String processor, String brand) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("update laptop_info set processor=?,brand=? where laptop_id=?");
            connection.setAutoCommit(false);

            preparedStatement.setString(1, processor);
            preparedStatement.setString(2, brand);
            preparedStatement.setInt(3, laptop_id);
            int row = preparedStatement.executeUpdate();
            connection.setAutoCommit(true);
            return row;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public int onDeleteById(int laptop_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("delete from laptop_info where laptop_id=?");
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, laptop_id);
            int row = preparedStatement.executeUpdate();
            connection.commit();
            return row;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
            return 0;

        }
    }
}