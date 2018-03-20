package com.pxl.student;

import Utility.BudgetPlannerDB;
import com.pxl.student.dao.*;
import com.pxl.student.bean.Account;
import com.pxl.student.bean.Payment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String number = generateRandomNumber();
        String IBAN = generateIBAN();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;

        System.out.println(AccountDao.getMaxIdFromAccount());

        System.out.println(AccountDao.getAccountById(AccountDao.getMaxIdFromAccount()));

    }

    private static String printResultString(int rowCount){
        String resultString;

        if(rowCount > 0){
            resultString  = ("Success");
        } else {
            resultString = ("Failure");
        }

        return resultString;
    }

    private static String generateRandomNumber(){
        Random random = new Random();
        String number = "" + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) ;

        return number;
    }

    private static String generateIBAN(){
        Random random = new Random();
        String number = "" + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) ;
        StringBuilder sb = new StringBuilder(number);
        sb.append("EB");
        sb.reverse();

        return sb.toString();
    }

}
