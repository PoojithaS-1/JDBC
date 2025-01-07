package com.xworkz.hotelapp.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HotelRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("poojitha");
    }
}
