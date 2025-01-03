package com.xworkz.ecommerceapp.DaoMobileRunner;
import com.xworkz.ecommerceapp.DaoMobile.MobileDao;
import com.xworkz.ecommerceapp.DaoMobile.MobileDaoImpl;

import java.sql.*;
public class MobileRunner {
    private static MobileDao mobileDao=new MobileDaoImpl();
    public static void main(String[] args) {
        int row=mobileDao.save( "Xiaomi Redmi Note 11", "XM-1111", "30000", "Xiaomi", "64GB");
        System.out.println(row+" Row  inserted successfully...!");

        ResultSet resultSet=mobileDao.getAllData();
        try {
            if (resultSet.isFirst()==false) {
                while (resultSet.next()){
                    int mobile_id=resultSet.getInt(1);
                    String mobile_name =resultSet.getString(2);
                    String model=resultSet.getString(3);
                    String price =resultSet.getString(4);
                    String brand =resultSet.getString(5);
                    String storage =resultSet.getString(6);
                    System.out.println("Mobile_id: "+mobile_id+"     Mobile_Name: "+ mobile_name +"     Model: "+model+"        price: "+ price +"      brand: "+ brand +"      Storage: "+ storage);
                }
            }else {
                System.out.println("No data found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}


