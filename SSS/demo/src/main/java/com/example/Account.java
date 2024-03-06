package com.example;

import java.util.Date;


public class Account implements Comparable<Account> {
    private int accountID;
    private int customerID;
    private double balance;
    private Date creationDate;

    // Constructor
    public Account(int accountID, int customerID, double balance) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.balance = balance;
        this.creationDate = new Date(); // Set creation date to the current date and time
    }

    // Getters
    public int getAccountID() {
        return accountID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Comparable implementation based on creation date and then balance
    @Override
    public int compareTo(Account otherAccount) {
        // First, compare by creation date
        int dateComparison = this.creationDate.compareTo(otherAccount.creationDate);
    
        // If the creation dates are equal, compare by balance
        if (dateComparison == 0) {
            return Double.compare(this.balance, otherAccount.balance);
        }
    
        return dateComparison;
    }

    public void addTransaction(Transaction transaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTransaction'");
    }

    public Object getTransactions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTransactions'");
    }
    


}
