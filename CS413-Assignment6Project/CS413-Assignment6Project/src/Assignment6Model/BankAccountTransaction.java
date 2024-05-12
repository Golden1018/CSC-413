/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author karunmehta
 */
public class BankAccountTransaction implements TransactionInterface {
    
    // Create instance variables
    private int id;
    private Timestamp createDate;
    private double amount;
    private String description;
    private String status;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private String type;
    
        //1-arg constructor
    public BankAccountTransaction() {
        Date dt = new Date();
        createDate = new Timestamp(dt.getTime());
    }
    
    BankAccountTransaction(BankAccount anAccount) {
        
        Date dt = new Date();
        
        createDate = new Timestamp(dt.getTime());
        sourceAccount = anAccount;
        
    }   
    
    BankAccountTransaction(BankAccount source, BankAccount target) {
        sourceAccount = source;
        destinationAccount = target;
        
    }   
    
    // Setters and getters for the FriscoCommunityBankAccount object
    
    public Timestamp getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Timestamp ld) {
        createDate = ld;
    }
    
    public void setID(int anId) {
        id = anId;
    }    
    
    public int id() {
        return id;
    }  

    public void setAmount(double aBalance) {
        amount = aBalance;
    }
    
    public double getAmount() {
        
        return amount;

    }

    public String getType() {
        return type;
    }  
    
    public void setType(String tp) {
        type = tp;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }      

    public BankAccount getTargetAccount() {
        return destinationAccount;
    } 

    public void setDescription(String desc) {
        description = desc;
    }    

    public String getDescription() {
        return description;
    }  
    
    
    @Override
    public String toString() {
        
        String str = "[ ";
        String acctString = null;
        
        str += "Transaction #: " + (this.id() + "\nTranaction Date: " + this.createDate.toString() + " TransactionAmount: " + this.getAmount());
        if(this.getSourceAccount() != null)            
            acctString += "Source Account: " + this.getSourceAccount().toString();
        else if (this.getSourceAccount() != null)            
            acctString += "Target Account: " + this.getSourceAccount().toString();

        return str += acctString + " ]";
    }

    public void execute() {
        this.execute();
    }  
    
}


