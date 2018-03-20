package com.pxl.student.dao;

import Utility.BudgetPlannerDB;
import com.pxl.student.bean.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class LabelDao {

    private int addLabelToPayment(int accountId, int paymentId, Label label){
        int rowCount = 0;
        String sql = "INSERT INTO Payment(labelId) VALUES (?) WHERE accountId = ? AND paymentId = ?;";

        try(Connection con = BudgetPlannerDB.getConnection();
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            statement.setInt(1, label.getId());
            statement.setInt(2, accountId);
            statement.setInt(3, paymentId);

            rowCount = statement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

        return rowCount;
    }

    public static int addLabel(Label label){
        int rowCount = 0;
        String sql = "INSERT INTO Label VALUES (default, ?, ?)";

        try(Connection connection = BudgetPlannerDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);){

            statement.setString(1, label.getDescription());
            statement.setString(2, label.getName());

            rowCount = statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rowCount;
    }

}
