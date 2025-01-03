package com.xworkz.ecommerceapp.daorunner;

import com.xworkz.ecommerceapp.dao.LaptopDao;
import com.xworkz.ecommerceapp.dao.LaptopDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetByprocessorAndBrandRunner {
    private static LaptopDao laptopDao=new LaptopDaoImpl();
    public static void main(String[] args) {
        boolean isempty=true;
        ResultSet resultSet=laptopDao.getByprocessorAndBrand("Intel Core i5","Asus");
        try {
            while (resultSet.next()){
                isempty=false;
                String processor =resultSet.getString(1);
                String brand=resultSet.getString(2);
                String model=resultSet.getString(3);
                System.out.println("Processor: "+ processor +"  Brand: "+brand+"  Model: "+model);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
