package com.xworkz.ecommerceapp.daorunner;

import com.xworkz.ecommerceapp.dao.LaptopDao;
import com.xworkz.ecommerceapp.dao.LaptopDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LaptopRunner {
    private static LaptopDao laptopDao=new LaptopDaoImpl();
    public static void main(String[] args) {
        int row=laptopDao.save("Asus", "ZenBook 14", "Intel Core i5", "8 GB", "699");
        System.out.println(row+ " row affected");

        ResultSet resultSet=laptopDao.getAllData();
        try {
            if (resultSet.isFirst()==false) {
                    while (resultSet.next()){
                        int laptop_id=resultSet.getInt(1);
                       String brand=resultSet.getString(2);
                       String model=resultSet.getString(3);
                       String processor=resultSet.getString(4);
                       String ram=resultSet.getString(5);
                       String price=resultSet.getString(6);
                        System.out.println("Laptop_id: "+laptop_id+" Brand: "+brand+" Model: "+model+" processor: "+processor+" Ram: "+ram+" Price: "+price);
                    }
            }else {
                System.out.println("No data found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
