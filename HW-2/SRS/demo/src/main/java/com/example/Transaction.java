package com.example;

import java.util.Date;

// Enum for TransactionType
enum TransactionType {
    DEPOSIT, WITHDRAWAL, TRANSFER
}

// DTO for representing Transaction data
class TransactionData {
    private String transactionId;
    private TransactionType transactionType;
    private double amount;

    public TransactionData(String transactionId, TransactionType transactionType, double amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    // Getters for TransactionData attributes
    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}

// Transaction class implementing PriorityComparable
class Transaction implements PriorityComparable {
    private String transactionId;
    private TransactionType transactionType;
    private double amount;
    private Date date;
    private Account associatedAccount;
    private User user; // Reference to the associated User

    public Transaction(String transactionId, TransactionType transactionType, double amount, Date date,
            Account associatedAccount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = (date != null) ? date : new Date(); // Set provided date or current date as default
    }

    @Override
    public Date getCreationDate() {
        // Assuming transaction date represents the creation date
        return getDate();
    }

    @Override
    public double getPriority() {
        // Priority based on transaction amount
        return getAmount();
    }

    @Override
    public int compareTo(PriorityComparable other) {
        // Implement the comparison logic based on priority
        return Double.compare(this.getPriority(), other.getPriority());
    }

    // Getters and setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAssociatedAccount(Account associatedAccount) {
        this.associatedAccount = associatedAccount;
    }

    public Account getAssociatedAccount() {
        return associatedAccount;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType + ", amount="
                + amount + "]";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public TransactionData fetchTransactionData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchTransactionData'");
    }

}
