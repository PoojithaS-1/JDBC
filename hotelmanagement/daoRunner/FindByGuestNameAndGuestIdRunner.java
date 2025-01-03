package com.xworkz.hotelmanagement.daoRunner;

import com.xworkz.hotelmanagement.dao.GuestDao;
import com.xworkz.hotelmanagement.dao.GuestDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByGuestNameAndGuestIdRunner {
    private static GuestDao guestDao=new GuestDaoImpl();

    public static void main(String[] args) {
        ResultSet resultSet=guestDao.getByGuestNameAndGuestId("David Lee",5);
        try {
            while (resultSet.next()){
                String check_in_date=resultSet.getString(4);
                String room_number=resultSet.getString(3);
                int guest_id=resultSet.getInt(1);
                String guest_name=resultSet.getString(2);

                System.out.println("Room_number: "+room_number+"    Check-in-date: "+check_in_date+"    guest_id: "+guest_id+ "    guest_name: "+guest_name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
