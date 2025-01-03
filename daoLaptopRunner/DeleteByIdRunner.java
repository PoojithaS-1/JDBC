package com.xworkz.ecommerceapp.daorunner;

import com.xworkz.ecommerceapp.dao.LaptopDao;
import com.xworkz.ecommerceapp.dao.LaptopDaoImpl;

public class DeleteByIdRunner {
    private static LaptopDao laptopDao=new LaptopDaoImpl();

    public static void main(String[] args) {
        int row= laptopDao.onDeleteById(4);
        System.out.println(row+" Row deleted successfully");
    }
}
