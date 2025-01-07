package com.xworkz.bankapp.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BankRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("poojitha");
    }
}
