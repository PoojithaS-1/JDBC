package com.xworkz.ecommerceapp.DaoMobile;

import java.nio.file.attribute.UserPrincipal;
import java.sql.*;

public class MobileDaoImpl implements MobileDao {
    final String URL = "jdbc:mysql://localhost:3306/ECOMMERCEAPP";
    final String USER = "root";
    final String PASS = "p00jitha@S";
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Override
    public int save(String mobile_name, String model, String price, String brand, String storage) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into mobile_info values(?,?,?,?,?,? )");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, mobile_name);
            preparedStatement.setString(3, model);
            preparedStatement.setString(4, price);
            preparedStatement.setString(5, brand);
            preparedStatement.setString(6, storage);
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
        return 0;
    }

    @Override
    public ResultSet getAllData() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            preparedStatement = connection.prepareStatement("select * from mobile_info");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByMobileIdAndName(int mobile_id, String mobile_name) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from mobile_info where mobile_id=? or mobile_name=?");
            preparedStatement.setInt(1, mobile_id);
            preparedStatement.setString(2, mobile_name);
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
    public ResultSet getByBrandAndStorage(String brand, String storage) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from mobile_info where brand=? and storage=?");
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, storage);
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
    public ResultSet getByPriceAndModel(String price, String model) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from mobile_info where price=? and model=?");
            preparedStatement.setString(1,price);
            preparedStatement.setString(2, model);
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
    public int updateByBrand(String brand, String storage, String price) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            preparedStatement = connection.prepareStatement("update mobile_info set storage=?,price=? where brand=?");
            connection.setAutoCommit(false);

            preparedStatement.setString(1, storage);
            preparedStatement.setString(2, price);
            preparedStatement.setString(3, brand);
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
    public int onDeleteById(int mobile_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            preparedStatement = connection.prepareStatement("delete from mobile_info where mobile_id=?");
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, mobile_id);
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