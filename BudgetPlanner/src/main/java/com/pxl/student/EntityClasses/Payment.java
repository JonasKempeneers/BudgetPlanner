package com.pxl.student.EntityClasses;

import javax.persistence.*;
import java.applet.AudioClip;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private float amount;
    private String currency;
    private String detail;

    private int accountId;
    private int counterAccountId;

    @ManyToOne
    @JoinColumn(name= "labelId")
    private Label label;

    public Payment(Date date, float amount, String currency, String detail, int accountId, int counterAccountId, Label label) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.detail = detail;
        this.accountId = accountId;
        this.counterAccountId = counterAccountId;
        this.label = label;
    }

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCounterAccountId() {
        return counterAccountId;
    }

    public void setCounterAccountId(int counterAccountId) {
        this.counterAccountId = counterAccountId;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
