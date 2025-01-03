package com.xworkz.hotelmanagement.dao;

import java.sql.*;

public class GuestDaoImpl implements GuestDao{
    final String URL ="jdbc:mysql://localhost:3306/HOTELMANAGEMENT";
    final String USER="root";
    final String PASSWORD ="p00jitha@S";
    Connection connection=null;
    PreparedStatement preparedStatement=null;


    @Override
    public int save(String guest_name, String room_number, String check_in_date, String check_out_date, String billing_address) {
        try {
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement= connection.prepareStatement("insert into guest_info values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,guest_name);
            preparedStatement.setString(3,room_number);
            preparedStatement.setString(4,check_in_date);
            preparedStatement.setString(5,check_out_date);
            preparedStatement.setString(6,billing_address);
            int row=preparedStatement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }
        }finally {
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
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from guest_info");
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.commit();
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
    public ResultSet getByGuestId(int guest_id) {
        try {
            connection=DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement("select * from guest_info where guest_id=?");
            preparedStatement.setInt(1,guest_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getByRoomNumberAndCheckInDate(String room_number, String check_in_date) {
        try {
            connection=DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement("select * from guest_info where room_number=? or check_in_date=?");
            preparedStatement.setString(1,room_number);
            preparedStatement.setString(2,check_in_date);
            ResultSet resultSet=preparedStatement.executeQuery();
            connection.commit();
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
    public ResultSet getByGuestNameAndGuestId(String guest_name, int guest_id) {
        try {
            connection=DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement("select * from guest_info where guest_name=? and guest_id=?");
            preparedStatement.setString(1,guest_name);
            preparedStatement.setInt(2,guest_id);
            ResultSet resultSet=preparedStatement.executeQuery();
            connection.commit();
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
    public int updateByGuestName(String guest_name,String check_in_date,String room_number) {
        try {
            connection=DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement("update guest_info set check_in_date=?,room_number=? where guest_name=? ");
            preparedStatement.setString(1,check_in_date);
            preparedStatement.setString(2,room_number);
            preparedStatement.setString(3,guest_name);
            int row=preparedStatement.executeUpdate();
            connection.commit();
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
    public int onDeleteById(int guest_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement("delete from guest_info where guest_id=?");
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, guest_id);
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
