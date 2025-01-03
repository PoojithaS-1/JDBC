package com.xworkz.hotelmanagement.daoRunner;

import com.xworkz.hotelmanagement.dao.GuestDao;
import com.xworkz.hotelmanagement.dao.GuestDaoImpl;

public class DeleteByIdRunner {
    private static GuestDao guestDao=new GuestDaoImpl();

    public static void main(String[] args) {
        int row= guestDao.onDeleteById(2);
        System.out.println(row+" Row deleted successfully");
    }
}
