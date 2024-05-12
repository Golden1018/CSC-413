/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Model.*;
import java.sql.SQLException;
import java.util.*;
import java.sql.Timestamp;

/**
 *
 * @author karunmehta
 */
public class AccountTransactionDTO {
    
    private int id;
    private String username;
    private String email;
    private String phone;
    private List address;
   
    static AccountTransactionDAO ato = new AccountTransactionDAO();

    //default custructor
    public AccountTransactionDTO() {
        

    }
    
    public static BankAccountTransaction transactionByAccountID(int anId) {
        
        BankAccountTransaction tran = null;
        
        try {
            
            tran = ato.get(anId);
            System.out.println("\nFetched Customer Address with CustomerID: " + anId + " Address Details:\n" + tran.toString());  
        
        } catch(SQLException se) {
        
            System.out.println(se.getMessage());
        
        }
              
        return tran;
        
}
    
    public static int performUpdate(BankAccountTransaction at) {

        int updateResult = -1;
        
        try {
            updateResult = ato.update(at);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) {
            System.out.println("\nUpdate Successful");
            System.out.println("Details of Transaction updated:\n " + at.toString());
        }
        
        return updateResult;        
    }

    public static int performCreate(HashMap hm) {

        int updateResult = -1;
        
        BankAccountTransaction at = new BankAccountTransaction();
        
        at.setCreateDate((Timestamp)hm.get("createdate"));
        at.setAmount((double)hm.get("amount"));
        at.setDescription((String)hm.get("summary"));
        at.setID((int)hm.get("id"));
        at.setType((String)hm.get("type"));
               
        try {
            updateResult = ato.create(at);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) {
            System.out.println("\nTranaction Create Successful");
            System.out.println("Details of created Transaction:\n" + at.toString());
        }
        
        return updateResult;        
    }
}
