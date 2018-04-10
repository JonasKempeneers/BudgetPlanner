package Utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

public class BudgetPlannerUtility {

    public static String generateRandomNumber(){
        Random random = new Random();
        String number = "" + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) ;

        return number;
    }

    public static String generateIBAN(){
        Random random = new Random();
        String number = "" + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) + random.nextInt(9999) ;
        StringBuilder sb = new StringBuilder(number);
        sb.append("EB");
        sb.reverse();

        return sb.toString();
    }

    public static int getAccountCount(){
        int count = 0;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BudgetPlanner");
        EntityManager em = emf.createEntityManager();

        //count = em.

        return count;
    }
}
