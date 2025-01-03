package com.xworkz.hotelmanagement.daoRunner;

import com.xworkz.hotelmanagement.dao.GuestDao;
import com.xworkz.hotelmanagement.dao.GuestDaoImpl;

public class UpdateByGuestNameRunner {
    private static GuestDao guestDao=new GuestDaoImpl();

    public static void main(String[] args) {
        int row=guestDao.updateByGuestName("Bob Johnson", "2025-01-01","R999");
        System.out.println(row+ " Row affected...!");
    }
}
