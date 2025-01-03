package com.xworkz.hotelmanagement.daoRunner;

import com.xworkz.hotelmanagement.dao.GuestDao;
import com.xworkz.hotelmanagement.dao.GuestDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByRoomNoAndCheckInDateRunner {
    private static GuestDao guestDao=new GuestDaoImpl();

    public static void main(String[] args) {
        ResultSet resultSet=guestDao.getByRoomNumberAndCheckInDate("R404","2022-01-01");
        try {
            while (resultSet.next()){
                int guest_id=resultSet.getInt(1);
                String check_in_date=resultSet.getString(4);
                String room_number=resultSet.getString(3);
                System.out.println("Room_number: "+room_number+"    Check-in-date: "+check_in_date+"    guest_id: "+guest_id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
