package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

// Enum for UserType
enum UserType {
    CUSTOMER, ADMINISTRATOR, TELLER, SECURITY
}

// DTO for representing User data
class UserData {
    private String userId;
    private String username;
    private UserType userType;

    public UserData(String userId, String username, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.userType = userType;
    }

    // Getters for UserData attributes
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public UserType getUserType() {
        return userType;
    }
}

// Comparable interface for prioritizing objects based on creation date and
// balance
interface PriorityComparable extends Comparable<PriorityComparable> {
    Date getCreationDate();
    double getCustomPriority();

    @Override
    default int compareTo(PriorityComparable other) {
        // First compare by creation date
        int dateComparison = getCreationDate().compareTo(other.getCreationDate());
        if (dateComparison != 0) return dateComparison;

        // Then compare by custom priority logic
        return Double.compare(this.getCustomPriority(), other.getCustomPriority());
    }
}

// User class implementing PriorityComparable
class User implements PriorityComparable {
    private String userId;
    private String username;
    private String password;
    private UserType userType;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private Date creationDate;


    public User(String userId, String username, String password, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.creationDate = new Date(); // Capture the creation time
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public double getCustomPriority() {
        // For User, prioritize based on creation date only
        return 0; // This value is ignored due to the logic in compareTo()
    }

    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int compareTo(PriorityComparable other) {
        // Implement the comparison logic based on priority
        return Double.compare(this.getCustomPriority(), other.getCustomPriority());
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", userType=" + userType + "]";
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setUser(this);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setUser(this);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Method stub to fetch user data
    public UserData fetchUserData() {
        return new UserData(userId, username, userType);
    }

    // Method stub to fetch associated accounts data
    public List<AccountData> fetchAssociatedAccountsData() {
        List<AccountData> accountDataList = new ArrayList<>();
        for (Account account : accounts) {
            accountDataList.add(account.fetchAccountData());
        }
        return accountDataList;
    }

    // Method stub to fetch associated transactions data
    public List<TransactionData> fetchAssociatedTransactionsData() {
        List<TransactionData> transactionDataList = new ArrayList<>();
        for (Transaction transaction : transactions) {
            transactionDataList.add(transaction.fetchTransactionData());
        }
        return transactionDataList;
    }

}
