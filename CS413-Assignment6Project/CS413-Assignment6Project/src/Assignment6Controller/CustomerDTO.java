/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author karunmehta
 */
public class CustomerDTO {
    
    private int id;
    private String username;
    private String email;
    private String phone;
    private List<String> address; // Assuming 'address' should be a list of strings

    static CustomerDAO cd = new CustomerDAO();

     // Constructors
    public CustomerDTO() {
        // default constructor
    }

    public CustomerDTO(int id, String username, String email, String phone, List<String> address) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    public static BankCustomer customerByID(int anId) {
        
        BankCustomer anCustomer = null;
        
        try {
            anCustomer = cd.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(anCustomer != null) System.out.println(anCustomer.toString()); 
            
        System.out.println("\nFetched Customer with ID: " + anId + " Customer Details:\n" + anCustomer.toString());        
        return anCustomer;
        
}

public static BankCustomer fromResultSet(ResultSet rs) throws SQLException {
    if (rs == null) return null;
    BankCustomer customer = new BankCustomer();
    customer.setCustId(rs.getInt("id"));
    customer.setFirstName(rs.getString("first_name"));
    customer.setLastName(rs.getString("last_name"));
    customer.setEmail(rs.getString("email"));
    customer.setPhone(rs.getString("phone"));
    return customer;
}

    
    public static int performUpdate(BankCustomer aCustomer) {

        int updateResult = -1;
        
        try {
            updateResult = cd.update(aCustomer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Customer Details:\n" + aCustomer.toString());
        return updateResult;        
    }

    public static int performCreate(HashMap hm) {

        int updateResult = -1;
        
        BankCustomer bc = new BankCustomer();
        
        bc.setEmail((String)hm.get("email"));
        bc.setLastName((String)hm.get("lname"));
        bc.setFirstName((String)hm.get("firstName"));
        bc.setPhone((String)hm.get("phone"));
        bc.setBirthday((String)hm.get("birthday"));
               
        try {
            updateResult = cd.create(bc);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nCustomer Create Successful");
        System.out.println("Customer Details:\n" + bc.toString());
        return updateResult;        
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}