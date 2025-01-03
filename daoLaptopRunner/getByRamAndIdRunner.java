package com.xworkz.ecommerceapp.daorunner;

import com.xworkz.ecommerceapp.dao.LaptopDao;
import com.xworkz.ecommerceapp.dao.LaptopDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getByRamAndIdRunner {
    private static LaptopDao laptopDao = new LaptopDaoImpl();

    public static void main(String[] args) {
        boolean isEmpty = true;
        ResultSet resultSet = laptopDao.getByRamAndId("16 GB", 1);
        try {
            while (resultSet.next()) {
                isEmpty = false;
                int laptop_id = resultSet.getInt(1);
                String brand = resultSet.getString(2);
                String model = resultSet.getString(3);
                String processor = resultSet.getString(4);
                String ram = resultSet.getString(5);
                String price = resultSet.getString(6);
                System.out.println("laptop_id: " + laptop_id + " Brand: " + brand + " Model: " + model + " Processor: " + processor + " Ram: " + ram + " Price: " + price);
            }
            if (isEmpty) {
                System.out.println("No records found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
