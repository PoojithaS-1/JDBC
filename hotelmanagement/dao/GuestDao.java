package com.xworkz.hotelmanagement.dao;

import java.sql.*;

public interface GuestDao {
    int save(String guest_name, String room_number, String check_in_date, String check_out_date, String billing_address);

    ResultSet getAllData();

    ResultSet getByGuestId(int guest_id);

    ResultSet getByRoomNumberAndCheckInDate(String room_number,String check_in_date);

    ResultSet getByGuestNameAndGuestId(String guest_name,int guest_id);

    int updateByGuestName(String guest_name,String check_in_date,String room_number);

    int onDeleteById(int guest_id) ;
}
