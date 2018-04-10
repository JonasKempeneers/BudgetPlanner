package com.pxl.student.EntityClasses;

import Utility.BudgetPlannerUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AccountRepo {

    private EntityManagerFactory _emf = Persistence.createEntityManagerFactory("Budgetplanner");

    public void AddAccount(String number, String IBAN, String name){

        EntityManager em = _emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Account account = new Account(number, IBAN, name);
        tx.begin();
        em.persist(account);
        tx.commit();
    }



}
