/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

/**
 *
 * @author karunmehta
 */
public class AdminDataConnection {
    
    // SQL queries tfor Admin object
    private static final String SELECT_ADMIN = "SELECT * FROM admin WHERE userid = ?";
 
    public AdminDataConnection()  { } 
    
    
    public static String getSelect() {
        
        return SELECT_ADMIN;
    }

    
}
