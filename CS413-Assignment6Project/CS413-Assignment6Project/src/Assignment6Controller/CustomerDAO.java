/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author karunmehta
 */

public class CustomerDAO implements DAOInterface<BankCustomer> {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    public CustomerDAO() {

            connection = DataConnection.getDBConnection();      

    }
       
    
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a user into the database
    @Override
    public int create(BankCustomer cust) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsert());
        pStatement.setString(1, cust.getFirstName());
        pStatement.setString(2, cust.getLastName());
        pStatement.setString(3, cust.getEmail());
        pStatement.setString(4, cust.getPhone());
        pStatement.setString(5, cust.getBirthday());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a user from the database by ID
    public BankCustomer get(int custId) throws SQLException {
        BankCustomer customer = null;
        String sql = "SELECT id, first_name, last_name, email, phone FROM bankcustomer WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, custId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                customer = new BankCustomer();
                customer.setCustId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
                // Add other fields as necessary
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
    
    
    
    
    
    
    
    

    // Method to update a user in the database
    @Override
public int update(BankCustomer cust) throws SQLException {
    int result = -1;
    pStatement = connection.prepareStatement(CustomerDataConnection.getUpdate());
    pStatement.setString(1, cust.getFirstName());
    pStatement.setString(2, cust.getLastName());
    pStatement.setString(3, cust.getEmail());
    pStatement.setString(4, cust.getPhone());
    pStatement.setInt(5, cust.getCustomerNumber()); // Ensure this matches the SQL WHERE clause identifier.result = pStatement.executeUpdate();
    result = pStatement.executeUpdate(); 
    return result;
}


    // Method to delete a user from the database
    @Override
    public int delete(BankCustomer cust) throws SQLException {
        
        int res = -1;
        
        pStatement = connection.prepareStatement(CustomerDataConnection.getDelete());
        pStatement.setInt(1, cust.getCustomerNumber());
        res = pStatement.executeUpdate();
        
        return res;
    }
    
    public HashMap validateLogin(String id) {
        
        HashMap hm = null;
        
        try {
            
            pStatement = connection.prepareStatement(CustomerDataConnection.getAdmin());
            pStatement.setString(1, id);
            result = pStatement.executeQuery();
            
            if (result.next()) {
                hm = new HashMap();
                hm.put("ID", result.getString("userid"));
                hm.put("PWD", result.getString("pwd"));
            }
            
        } catch( Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage() + " Try again..");
        }
        
        return hm;
    }

    public List<BankCustomer> findByCity(String city) throws SQLException {
        List<BankCustomer> customers = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        try {
            String sql = "SELECT * FROM customeraddress WHERE city = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, city);
            rs = stmt.executeQuery();
    
            while (rs.next()) {
                BankCustomer customer = new BankCustomer(
                    rs.getInt("custid"),
                    rs.getString("city"),
                    rs.getString("state"),
                    rs.getString("streetname"),
                    rs.getInt("streetnum"),
                    rs.getString("zip")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Database error: " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
    
        return customers;
    }


   
    public BankCustomer getCustomerById(int id) {
        // Example SQL query, adjust according to your schema
        String sql = "SELECT * FROM bankcustomer WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                BankCustomer customer = new BankCustomer();
                // Assume setters exist
                customer.setCusId(rs.getInt("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                // continue setting other fields
                return customer;
            } else {
                System.out.println("No record found with ID: " + id); // Log if no record is found
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log SQL exceptions
        }
        return null;
    }
    

    
    
    
    
    
    

    
}
