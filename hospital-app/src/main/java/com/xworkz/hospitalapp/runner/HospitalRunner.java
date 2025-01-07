package com.xworkz.hospitalapp.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HospitalRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("poojitha");
    }
}
