package com.xworkz.ecommerceapp.DaoMobileRunner;

import com.xworkz.ecommerceapp.DaoMobile.MobileDao;
import com.xworkz.ecommerceapp.DaoMobile.MobileDaoImpl;

public class UpdateByBrandRunner {
    private static MobileDao mobileDao=new MobileDaoImpl();

    public static void main(String[] args) {
        int row=mobileDao.updateByBrand("Apple","128GB","70000");
        System.out.println(row+ " Row Affected...!");
    }
}
