package com.xworkz.hotelmanagement.daoRunner;

import com.xworkz.hotelmanagement.dao.GuestDao;
import com.xworkz.hotelmanagement.dao.GuestDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestRunner {
    private static GuestDao guestDao=new GuestDaoImpl();
    public static void main(String[] args) {
        int row=guestDao.save("David Lee", "R505", "2022-01-20", "2022-01-22", "901 Pine St");
        System.out.println(row+" inserted successfully");

        ResultSet resultSet=guestDao.getAllData();
        try {
            if(resultSet.isFirst()==false) {
                while (resultSet.next()) {
                    int guest_id=resultSet.getInt(1);
                    String  guest_name=resultSet.getString(2);
                    String room_number=resultSet.getString(3);
                    String check_in_date=resultSet.getString(4);
                    String check_out_date=resultSet.getString(5);
                    String billing_address=resultSet.getString(6);
                    System.out.println("Guest_id: "+guest_id+ "     Guest_name: "+guest_name+"      Room_number: "+room_number+"        Check_in_date: "+check_in_date+"        Check_out_date: "+check_out_date+"      Billing_addr: "+billing_address);

                }
            }else {
                System.out.println("No data found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

