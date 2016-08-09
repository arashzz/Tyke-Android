package com.toranj.tyke.models;

import java.util.Date;

/**
 * Created by arash on 8/5/16.
 */
public class Spending extends Base {

    Date receiptDate;
    Date expirydate;
    double amount;

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
