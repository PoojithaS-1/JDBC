package com.xworkz.ecommerceapp.daorunner;

import com.xworkz.ecommerceapp.dao.LaptopDao;
import com.xworkz.ecommerceapp.dao.LaptopDaoImpl;

public class updateByLaptop_idRunner {
    private static LaptopDao laptopDao=new LaptopDaoImpl();
    public static void main(String[] args) {
        int row=laptopDao.updateByLaptop_id(4,"Intel Core i3","Lenovo");
        System.out.println(row+ " Row Affected...!");

    }
}
