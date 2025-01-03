package com.xworkz.ecommerceapp.daorunner;

import com.xworkz.ecommerceapp.dao.LaptopDao;
import com.xworkz.ecommerceapp.dao.LaptopDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetByIdAndBrandRunner {
    private static LaptopDao laptopDao=new LaptopDaoImpl();
    public static void main(String[] args) {
        boolean isempty=true;
            ResultSet resultSet=laptopDao.getByIdAndBrand(2,"Apple");
        try {
            while (resultSet.next()){
                isempty=false;
                int laptop_id=resultSet.getInt(1);
                String brand=resultSet.getString(2);
                String model=resultSet.getString(3);
                System.out.println("Laptop_id: "+laptop_id+"  Brand: "+brand+"  Model: "+model);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
