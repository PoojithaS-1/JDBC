package com.xworkz.ecommerceapp.DaoMobileRunner;

import com.xworkz.ecommerceapp.DaoMobile.MobileDao;
import com.xworkz.ecommerceapp.DaoMobile.MobileDaoImpl;

public class DeleteByIdRunner {
    private static MobileDao mobileDao=new MobileDaoImpl();

    public static void main(String[] args) {
        int row= mobileDao.onDeleteById(3);
        System.out.println(row+" Row deleted successfully");
    }
}
