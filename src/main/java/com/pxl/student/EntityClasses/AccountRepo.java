package com.pxl.student.EntityClasses;

import Utility.BudgetPlannerUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AccountRepo {

    private EntityManagerFactory _emf = Persistence.createEntityManagerFactory("BudgetPlanner");

    public void AddAccount(Account account){

        EntityManager em = _emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(account);
        tx.commit();
    }



}
