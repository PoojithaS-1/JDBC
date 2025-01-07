package com.xworkz.bookingapp.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookingRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("poojitha");
    }
}
