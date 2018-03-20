package com.pxl.student.dao;

import Utility.BudgetPlannerDB;
import com.pxl.student.bean.Payment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PaymentDao {

    public static int addPayment(int accountId, Payment payment){
        int rowCount = 0;
        String sql = "INSERT INTO Payment(id, date, amount, currency, detail, accountId, counterAccountId, labelId)" +
                "VALUES(default, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = BudgetPlannerDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setDate(1, new Date(500));
            statement.setFloat(2, payment.getAmount());
            statement.setString(3, payment.getCurrency());
            statement.setString(4, payment.getDetail());
            statement.setInt(5, payment.getAccountId());
            statement.setInt(6, payment.getCounterAccountId());
            statement.setInt(7, payment.getLabelId());

            rowCount = statement.executeUpdate();


        } catch (Exception e){
            e.printStackTrace();
        }

        return rowCount;
    }

}
