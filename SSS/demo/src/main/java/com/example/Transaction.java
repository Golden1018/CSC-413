package com.example;

import java.sql.Date;

public class Transaction implements Comparable<Transaction> {
    private int transactionID;
    private int accountID;
    private String transactionType;
    private double amount;
    private String transactionDetails;
    private Date creationDate;

    // Constructor
    public Transaction(int transactionID, int accountID, String transactionType, double amount, String transactionDetails) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDetails = transactionDetails;
        this.creationDate = new Date(accountID); // Set creation date to the current date and time
    }

    // Getters
    public int getTransactionID() {
        return transactionID;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionDetails() {
        return transactionDetails;
    }

    // Setters
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    @Override
    public int compareTo(Transaction otherTransaction) {
        // First, compare by creation date
        int dateComparison = this.creationDate.compareTo(otherTransaction.creationDate);

        // If the creation dates are equal, compare by amount
        if (dateComparison == 0) {
            return Double.compare(otherTransaction.amount, this.amount); // Higher amount gets higher priority
        }

        return dateComparison;
    }
}
