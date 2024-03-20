/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs413swingdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author karunmehta
 */
class EmployeeDAOConcrete implements EmployeeDAO {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;

    EmployeeDAOConcrete() {

        try {

            connection = EmployeeDataConnection.getDBConnection();

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

    }

    public static Connection getConnection() {

        if (connection == null) {
            try {

                connection = EmployeeDataConnection.getDBConnection();

            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }
        }

        return connection;
    }

    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a user into the database
    @Override
    public int insert(Employee emp) throws SQLException {

        int res = -1;
        pStatement = connection.prepareStatement(EmployeeDataConnection.getInsert());
        pStatement.setString(1, emp.getUsername());
        pStatement.setString(2, emp.getEmail());
        res = pStatement.executeUpdate();
        disconnect();

        return res;
    }

    // Method to retrieve a user from the database by ID
    @Override
    public Employee get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(EmployeeDataConnection.getSelect());
        pStatement.setInt(1, anID);
        result = pStatement.executeQuery();

        Employee updatedEmp = null;
        if (result.next()) {
            Employee e = new Employee();
            updatedEmp = new Employee(result.getInt("id"), result.getString("username"), result.getString("email"),
                    result.getString("phone"));
        }

        return updatedEmp;
    }

    // Method to update a user in the database
    @Override
    public int update(Employee emp) throws SQLException {

        int result = -1;

        pStatement = connection.prepareStatement(EmployeeDataConnection.getUpdate());
        pStatement.setString(1, emp.getUsername());
        pStatement.setString(2, emp.getEmail());
        pStatement.setString(3, emp.getPhone());
        pStatement.setInt(4, emp.getID());
        result = pStatement.executeUpdate();

        return result;
    }

    // Method to delete a user from the database
    @Override
    public int delete(Employee emp) throws SQLException {

        int res = -1;

        pStatement = connection.prepareStatement(EmployeeDataConnection.getDelete());
        pStatement.setInt(1, emp.getID());
        res = pStatement.executeUpdate();

        return res;
    }

    // Method to update a user in the database
    @Override
    public int save(Employee emp) throws SQLException {

        int res = -1;

        String nameStr = emp.getUsername();
        String[] strArr = nameStr.split(" ");
        pStatement = connection.prepareStatement(EmployeeDataConnection.getInsert());
        pStatement.setString(1, strArr[0]);
        pStatement.setString(2, strArr[1]);
        pStatement.setString(3, emp.getEmail());
        pStatement.setString(4, emp.getPhone());
        pStatement.setString(5, emp.getDepartment());
        res = pStatement.executeUpdate();

        return res;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public HashMap validateLogin(String id) {
        // Create a new HashMap
        HashMap hm = new HashMap();

        // Temporary hardcoded values for testing
        String hardcodedID = "ID";
        String hardcodedPassword = "123";

        // Check if the provided ID matches the hardcoded value
        if (id.equals(hardcodedID)) {
            // If it matches, put the hardcoded values into the HashMap
            hm.put("ID", hardcodedID);
            hm.put("PWD", hardcodedPassword);
        } else {
            // If not, you can return null, an empty map, or indicate failure in some other
            // way
            // Returning an empty HashMap for this example
            hm = null; // Or `new HashMap()` if you want to return an empty map instead of null
        }

        return hm;
    }

}
