package com.pxl.student;

import Utility.BudgetPlannerDB;
import com.pxl.student.bean.Account;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BudgetPlannerTest extends TestCase {

    public void testAddAccountToDatabase(){
        String number = BudgetPlannerDB.generateRandomNumber();
        String IBAN = BudgetPlannerDB.generateIBAN();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BudgetPlanner");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Account account = new Account(number, IBAN, "Joske");
        em.persist(account);
        tx.commit();
        em.close();
        emf.close();

        Account expectedAccount = account;
        Account actualAccount;
    }

}
