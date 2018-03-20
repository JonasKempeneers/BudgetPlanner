package com.pxl.student.dao;

import Utility.BudgetPlannerDB;
import com.pxl.student.bean.Account;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AccountDaoTest extends TestCase {

    AccountDao accountDao;

    @Before
    public void setUp() throws Exception{
        accountDao = new AccountDao();
    }

    @Test
    public void testAddAccount() {

        //Arrange number iban name
        String number;
        String IBAN;
        Account expectedAccount;
        Account actualAccount;
        int rowCount;
        int accountId;

        //Act
        number  = BudgetPlannerDB.generateRandomNumber();
        IBAN  = BudgetPlannerDB.generateIBAN();
        expectedAccount = new Account(AccountDao.getMaxIdFromAccount() + 1 ,number, IBAN, "Jos Bammens");

        rowCount = AccountDao.addAccount(expectedAccount);

        accountId = AccountDao.getMaxIdFromAccount();

        actualAccount = AccountDao.getAccountById(accountId);


        //Assert
        assertEquals(expectedAccount, actualAccount);

    }
}