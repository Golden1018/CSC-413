/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Model;

import java.time.*;


import Assignment6Model.BankCustomer;

/**
 *
 * @author karunmehta
 */
public abstract class BankAccount implements Comparable<BankAccount> {
    
    // Create instance variables
    
    private BankCustomer customer;
    public String type;
    public int custNum;
    
    private String accountNumber;
    public double balance;
    public String accountType;
    private String customerName;
    protected int accountNum;
    protected LocalDate createDate;

    protected int custId;


    protected LocalDate lastUpdateDate;

    
    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public BankAccount(String accountNumber, double balance, String accountType, String customerName, int custId) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.accountType = accountType;
    this.customerName = customerName;
    this.custId = custId;  // Ensure this line is added
    this.createDate = LocalDate.now();
}


    public BankAccount(String accountNumber, double balance, String accountType, String customerName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.customerName = customerName;
        this.createDate = LocalDate.now();

        System.out.println("Created BankAccount with: " + this);
    }

    public BankAccount(String accountNumber, int accountNum, String accountType, String customerName) {
        this.accountNumber = accountNumber;
        this.accountNum = accountNum;
        this.createDate = LocalDate.now();
        this.accountType = accountType;
        this.customerName = customerName;

        System.out.println("Created BankAccount with: " + this);
    }

    public BankAccount(String accountNumber, int accountNum) {
        this.accountNumber = accountNumber;
        this.accountNum = accountNum;
        this.createDate = LocalDate.now();
    }

    
    public int getCustId() {
        return this.custId;
    }
    
  

    public double getBalance() {
        return balance;
    }

   
    
    
    static String bankName = "DefaultBankName";
    private int currentNumber = 0;
    
        //1-arg constructor
    BankAccount() {
        accountNum = currentNumber++;
        createDate = LocalDate.now();
        
    }

    

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    BankAccount(int actNum) {
        accountNum = actNum;
        createDate = LocalDate.now();
        
    }    

    

   
    
    // Setters and getters for the FriscoCommunityBankAccount object
    
    public java.time.LocalDate getCreateDate() {
        return createDate;
    }
    
    
    
    
    
    
    public String getType() {
        return type;
    }  
    
    public void setType(String tp) {
        type = tp;
    }
    
    public int getAccountNum() {
        return accountNum;
    }
    
    

        public String getName() {
        return bankName;
    }
    
    public void setBankName(String name) {
        bankName = name;
    }

    public String getCustNum() {
        return type;
    }      

    public void setCustNum(int num) {
        custNum = num;
    }    
    
    @Override
    public int compareTo(BankAccount ba) {
        return this.compareTo(ba);
    }
    
    @Override
    public String toString() {
        
        String str = "[ ";
        
        str += "Num: " + (this.getAccountNum() + " Create Date: " + this.createDate.toString() + " Balance: " + this.getBalance());
        
        return str + " ]";
        
    }

    
    
    
    public boolean withdraw(double amnt) {

        boolean result = false;

        if(this.balance > amnt) {
            balance -= amnt;
            result = true;
        }
        
        return result;
    
    }
        
    public boolean deposit(double amnt) {

            this.setBalance(balance + amnt);
            return true;
    
    }
    
    public boolean transfer(BankAccount acct, double amnt) {

        boolean result = false;

        if(acct.balance > amnt) {
            acct.setBalance(balance - amnt);
            this.setBalance(balance + amnt);
            result = true;
        }
        
        return result;
    
    }

    // getters and setters

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    
    public int getId() {
        return this.accountNum;
    }
    
    

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public static class CheckingAccount extends BankAccount {
        private double odLimit;  // Overdraft limit for checking accounts

        public CheckingAccount(int accountNum, double odLimit) {
            super(accountNum);
            this.odLimit = odLimit;
        }

        public void setOdLimit(double odLimit) {
            this.odLimit = odLimit;
        }

        public double getOdLimit() {
            return this.odLimit;
        }
    }

    public static class SavingsAccount extends BankAccount {
        private double interestRate;

        public SavingsAccount(int accountNum, double interestRate) {
            super(accountNum);
            this.interestRate = interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public double getInterestRate() {
            return this.interestRate;
        }
    }

    // Getter for account type
    

    
    public String getCustomerOffset() {
        return customerName;
    }
    
    

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        System.out.println("Set accountNumber to: " + accountNumber);
    }

    

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        System.out.println("Set customerName to: " + customerName);
    }

    public void setBalance(double balance) {
        this.balance = balance;
        System.out.println("Set balance to: " + balance);
    }

    // Override the toString method to print all relevant fields
   
    public String getAccountAccountType() {
        return this.accountType; // Assuming accountType is a field within BankAccount
    }

    

    public void setCustomer(BankCustomer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        if (customer != null) {
            return customer.getName();
        } else {
            return "No customer data";
        }
    }
    
}