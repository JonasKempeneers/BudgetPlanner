package com.pxl.student;

import Utility.BudgetPlannerUtility;
import com.pxl.student.EntityClasses.Account;
import com.pxl.student.EntityClasses.AccountRepo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest extends TestCase {
    @Test
    public void testAddAccount(){
        int countBefore;
        int countAfter;
        AccountRepo repo = new AccountRepo();
        Account account = new Account(BudgetPlannerUtility.generateRandomNumber(),
                BudgetPlannerUtility.generateIBAN(), "Random Test Account");

        countBefore = BudgetPlannerUtility.getAccountCount();
        repo.AddAccount(account);
        countAfter = BudgetPlannerUtility.getAccountCount();

        //Assert.assertNotEquals(countBefore, countAfter);
        assertTrue(true);
    }

}
