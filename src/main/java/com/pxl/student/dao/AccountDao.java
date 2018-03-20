package com.pxl.student.dao;

import Utility.BudgetPlannerDB;
import com.pxl.student.bean.Account;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {

    public static int addAccount(Account account){
        String sql = "INSERT INTO Account VALUES (default, ? , ?, ?)";
        int rowCount = 0;
        try (Connection con = BudgetPlannerDB.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);) {

            statement.setString(1, account.getNumber());
            statement.setString(2, account.getIBAN());
            statement.setString(3, account.getName());

            rowCount = statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

        return rowCount;
    }

    public static Account getAccountById(int id){
        String sql = "SELECT * FROM Account WHERE Id = ?";
        Account account = null;

        try(Connection con = BudgetPlannerDB.getConnection();
        PreparedStatement statement = con.prepareStatement(sql)){

            statement.setInt(1, id);

            ResultSet rs  = statement.executeQuery();
            if(rs != null){
                //rs.next();
                int accountId = Integer.parseInt(rs.getString("id"));
                rs.next();
                String number = rs.getString("number");
                rs.next();
                String IBAN = rs.getString("IBAN");
                rs.next();
                String name = rs.getString("name");
                account = new Account(accountId, number, IBAN, name);
            } else {
                account = new Account(0, "null", "null", "null");
            }





        }catch (Exception e){
            e.printStackTrace();
        }

        return account;
    }

    public static int getMaxIdFromAccount(){
        String sql = "SELECT COUNT(id) FROM Account;";
        int count = 0;

        try(Connection con = BudgetPlannerDB.getConnection();
            PreparedStatement statement = con.prepareStatement(sql)){

            ResultSet rs = statement.executeQuery();
            rs.next();
            count = rs.getInt(1);

        }catch (Exception e){
            e.printStackTrace();
        }

        return count;
    }

}
