package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

public class BudgetPlannerDB {

    private static Connection connection;

    public static Connection getConnection() {

        try{
            connection = DriverManager.getConnection("jdbc:mysql://192.168.33.22/budgetplanner?useSSL=false", "student", "student");
        } catch(Exception e){
            e.printStackTrace();
        }

        return connection;
    }

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
}
