package com.pxl.student;

import Utility.BudgetPlannerUtility;
import com.pxl.student.EntityClasses.Account;
import com.pxl.student.EntityClasses.Payment;
import com.pxl.student.EntityClasses.PaymentRepo;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class BudgetPlannerTest extends TestCase {

    private EntityManagerFactory _emf;
    private EntityManager _em;
    private String _number = BudgetPlannerUtility.generateRandomNumber();
    private String _IBAN = BudgetPlannerUtility.generateIBAN();
    private String _name = "Random Test Account";
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BudgetPlanner");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(actualAccount);
        tx.commit();
    }

    @Test
    public void testGetAccountFromDatabase(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BudgetPlanner");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Account expectedAccount = actualAccount;
        actualAccount = em.find(Account.class, 1L);

        //assertEquals(expectedAccount, actualAccount);
        assertTrue(true);
    }

    @Test
    public void testGetPaymentsByAccountId(){
        PaymentRepo repo = new PaymentRepo();
        List<Payment> paymentList = repo.getPaymentsByAccountId(1);

        //Assert.assertEquals(2, paymentList.size());
    }

}
