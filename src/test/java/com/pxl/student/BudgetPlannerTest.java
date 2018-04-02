package com.pxl.student;

import Utility.BudgetPlannerDB;
import com.pxl.student.bean.Account;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BudgetPlannerTest extends TestCase {

    private EntityManagerFactory _emf;
    private EntityManager _em;
    private EntityTransaction _tx;
    private String _number = BudgetPlannerDB.generateRandomNumber();
    private String _IBAN = BudgetPlannerDB.generateIBAN();
    private String _name = "Random Test Accout";
    Account actualAccount = createAccount();

    private Account createAccount(){
        Account account = new Account(_number, _IBAN, _name);
        return account;
    }

    @Before
    public void SetUp(){
        _emf = Persistence.createEntityManagerFactory("BudgetPlanner");
        _em = _emf.createEntityManager();
    }

    @After
    public void After(){
        _em.close();
        _emf.close();
    }

    @Test
    public void testAddAccountToDatabase(){
        _tx = _em.getTransaction();
        _tx.begin();
        _em.persist(actualAccount);
        _tx.commit();


    }

    @Test
    public void testGetAccountFromDatabase(){

        _tx = _em.getTransaction();
        _tx.begin();
        Account expectedAccount = actualAccount;
        actualAccount = _em.find(Account.class, 1L);

        assertEquals(expectedAccount, actualAccount);
    }

}
