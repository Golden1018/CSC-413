/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author karunmehta
 */
public class AdminDTO {
   
    static AdminDAO ad = new AdminDAO();

    public AdminDTO() {
        
    } 
    
    public static boolean validateAdmin(String givenID, String givenPwd) {
        
        boolean success = false;

        HashMap hm = ad.getAdmin(givenID);

        if(hm != null) {
            String fetchedPwd = (String)hm.get("PWD");
            success = givenPwd.equalsIgnoreCase(fetchedPwd);
        }
        
        return success;
    }
}
        
