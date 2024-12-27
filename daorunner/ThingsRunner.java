package com.xworkz.libsystem.retriver.daorunner;

import com.xworkz.libsystem.retriver.dao.ThingsDao;
import com.xworkz.libsystem.retriver.dao.ThingsDaoImpl;

public class ThingsRunner {
    private static ThingsDao thingsDao=new ThingsDaoImpl();
    public static void main(String[] args) {
        int row=thingsDao.save("SmartPhone","Oppo","blue");
        System.out.println(row+" row affected");
    }
}
