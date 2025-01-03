package com.xworkz.ecommerceapp.DaoMobileRunner;

import com.xworkz.ecommerceapp.DaoMobile.MobileDao;
import com.xworkz.ecommerceapp.DaoMobile.MobileDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByMobileIdAndNameRunner {
    private static MobileDao mobileDao=new MobileDaoImpl();

    public static void main(String[] args) {
       ResultSet resultSet= mobileDao.getByMobileIdAndName(2,"OnePlus 9 Pro");
        boolean isempty=true;
        try {
            while (resultSet.next()){
                isempty=false;
                int mobile_id =resultSet.getInt(1);
                String mobile_name=resultSet.getString(2);
                String model=resultSet.getString(3);
                System.out.println("Laptop_id: "+ mobile_id +"  mobile_name: "+mobile_name+"  Model: "+model);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}

