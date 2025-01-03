package com.xworkz.hotelmanagement.daoRunner;

import com.xworkz.hotelmanagement.dao.GuestDao;
import com.xworkz.hotelmanagement.dao.GuestDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByGuestIdRunner {
    private static GuestDao guestDao=new GuestDaoImpl();

    public static void main(String[] args) {
        ResultSet resultSet=guestDao.getByGuestId(4);
            try {
                while (resultSet.next()) {
                    int guest_id=resultSet.getInt(1);
                    String guest_name=resultSet.getString(2);
                    System.out.println("Guest_id: "+guest_id+ "    Guest_name: "+guest_name);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
}
