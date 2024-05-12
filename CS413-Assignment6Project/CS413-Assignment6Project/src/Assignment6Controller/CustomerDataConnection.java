 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author karunmehta
 */
public class CustomerDataConnection extends DataConnection {
    


    // SQL queries to be used to persist customer business objects as needed by the DAO
    private static final String INSERT_SQL = "INSERT INTO Customer (first_name, last_name, email, phone, birthday) VALUES (?, ?, ?, ?,?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM Customer WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE Customer SET username = ?, email = ?, phone = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Customer WHERE id = ?"; 
    private static final String SELECT_ADMIN = "SELECT * FROM admin WHERE userid = ?";
 
    public CustomerDataConnection()  { } 
    
    public static String getInsert() {
        
        return INSERT_SQL;
    }
    
    public static String getUpdate() {
        
        return UPDATE_SQL;
    }
    
    public static String getSelect() {
        
        return SELECT_SQL_BYID;
    }
    
    public static String getDelete() {
        
        return DELETE_SQL;
    }    
    
}

