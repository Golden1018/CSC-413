/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Model.*;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author karunmehta
 */
public class CustomerAddressDTO {
    
    private int id;
    private String username;
    private String email;
    private String phone;
    private List address;
   
    static CustomerAddressDAO ad = new CustomerAddressDAO();

    //default custructor
    public CustomerAddressDTO() {
        

    }
    
    public static CustomerAddress customerAddressByID(int anId) {
        
        CustomerAddress addr = null;
        
        try {
            
            addr = ad.get(anId);
            System.out.println("\nFetched Customer Address with CustomerID: " + anId + " Address Details:\n" + addr.toString());  
        
        } catch(SQLException se) {
        
            System.out.println(se.getMessage());
        
        }
        if(addr != null) System.out.println(addr.toString()); 
              
        return addr;
        
}
    
    public static int performUpdate(CustomerAddress addr) {

        int updateResult = -1;
        
        try {
            updateResult = ad.update(addr);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Customer Details:\n" + addr.toString());
        return updateResult;        
    }

    public static int performCreate(HashMap hm) {

        int updateResult = -1;
        
        CustomerAddress ca = new CustomerAddress();
        
        ca.setStreetNum((int)hm.get("streetnum"));
        ca.setStreet((String)hm.get("streetname"));
        ca.setCity((String)hm.get("city"));
        ca.setState((String)hm.get("state"));
        ca.setZip((int)hm.get("zip"));
               
        try {
            updateResult = ad.create(ca);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nCustomerAddress Create Successful");
        System.out.println("Customer Details:\n" + ca.toString());
        return updateResult;        
    }
}
