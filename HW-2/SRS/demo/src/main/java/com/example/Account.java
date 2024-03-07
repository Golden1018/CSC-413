package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Enum for AccountType
enum AccountType {
    SAVINGS, CHECKING
}

// Enum for AccountStatus
enum AccountStatus {
    ACTIVE, INACTIVE
}

// DTO for representing Account data
class AccountData {
    private String accountNumber;
    private AccountType accountType;
    private double balance;
    private AccountStatus accountStatus;

    public AccountData(String accountNumber, AccountType accountType, double balance, AccountStatus accountStatus) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.accountStatus = accountStatus;
    }

    // Getters for AccountData attributes
    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }
}

// Account class implementing PriorityComparable
class Account implements PriorityComparable {
    private String accountNumber;
    private AccountType accountType;
    private double balance;
    private AccountStatus status;
    private User user; // Reference to the associated User
    private List<Transaction> transactions; // List to store associated transactions

    public Account(String accountNumber, AccountType accountType, double balance, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
        this.transactions = new ArrayList<>();
    }

    @Override
    public double getPriority() {
        // Priority based on account balance
        return getBalance();
    }

    @Override
    public int compareTo(PriorityComparable other) {
        // Implement the comparison logic based on priority
        return Double.compare(this.getPriority(), other.getPriority());
    }

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public Date getCreationDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCreationDate'");
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
                + "]";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        // Set the associated account for the transaction
        transaction.setAssociatedAccount(this);
    }

    public AccountData fetchAccountData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchAccountData'");
    }
}
