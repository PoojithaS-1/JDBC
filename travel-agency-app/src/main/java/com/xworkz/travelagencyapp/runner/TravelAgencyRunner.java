package com.xworkz.travelagencyapp.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TravelAgencyRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("poojitha");
    }
}
