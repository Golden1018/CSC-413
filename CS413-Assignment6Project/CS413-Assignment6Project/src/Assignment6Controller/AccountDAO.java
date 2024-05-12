/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Controller.*;
import Assignment6Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author karunmehta
 */
public class AccountDAO implements DAOInterface<BankAccount>{

    private static AccountDAO instance;
    private static Connection connection = null;
    private PreparedStatement pStatement;
    private ResultSet result;
    final String checking = "CH";
    final String saving = "SV";

    AccountDAO() {

        connection = DataConnection.getDBConnection();

    }
               
    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }
    
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a user into the database
    @Override
    public int create(BankAccount act) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(AccountDataConnection.getInsert());
        pStatement.setInt(1, act.getAccountNum());
        pStatement.setDouble(2, act.getBalance());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a user from the database by ID
    @Override
    public BankAccount get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(AccountDataConnection.getSelect());
        pStatement.setInt(1,anID);
        result = pStatement.executeQuery();
        
        BankAccount updatedAct = null;
        if (result.next()) {
            if(result.getString("acct_type").equalsIgnoreCase(checking))
                updatedAct = new CheckingAccount( result.getInt("id"));
            else
                updatedAct = new SavingsAccount( result.getInt("id"));
            
            updatedAct.setBalance(result.getFloat("balance"));
            LocalDate ld = createLocalDate(result.getString("create_date"));
            updatedAct.setCreateDate(ld);
        }
      
        return updatedAct;
    }

    private LocalDate createLocalDate(String dateStr) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        
        return localDate;
        
    }
    
    // Method to update a user in the database
    @Override
    public int update(BankAccount act) throws SQLException {
        
        int result = -1;
       
        pStatement = connection.prepareStatement(AccountDataConnection.getUpdate());
        pStatement.setString(1, act.getCustNum());
        pStatement.setDouble(1, act.getBalance());

        pStatement.setString(2, act.getCreateDate().toString());
        pStatement.setString(3, act.getType());
        pStatement.setInt(4, act.getAccountNum());
        result = pStatement.executeUpdate();
        
        return result;
    }

    // Method to delete a user from the database
    @Override
    public int delete(BankAccount act) throws SQLException {
        
        int res = -1;
        
        pStatement = connection.prepareStatement(AccountDataConnection.getDelete());
        pStatement.setInt(1, act.getAccountNum());
        res = pStatement.executeUpdate();
        
        return res;
    }  

    public List<BankAccount> getBankRequestsByCustomerId(int customerId) throws SQLException {
        List<BankAccount> accounts = new ArrayList<>();
        
        //String sql = "SELECT acct_num, cust_id, balance, create_date, last_update_date, acct_type, od_limit, int_rate FROM bankaccount WHERE cust_id = ?";
        String sql = "SELECT a.acct_num, a.cust_id, a.balance, a.create_date, a.last_update_date, a.acct_type, a.od_limit, a.int_rate, c.first_name, c.last_name FROM bankaccount a JOIN bankcustomer c ON a.cust_id = c.id WHERE a.cust_id = ?";

        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setInt(1, customerId);
        ResultSet result = pStatement.executeQuery();
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
        while (result.next()) {
            
            // Concatenate first name and last name with a space in between
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            if (firstName == null || lastName == null) {
                System.out.println("One or both names are null"); // Debugging output
            }
            BankCustomer customer = new BankCustomer(result.getInt("cust_id"), firstName, lastName);

            BankAccount account;
            if ("CH".equalsIgnoreCase(result.getString("acct_type"))) {
                account = new BankAccount.CheckingAccount(result.getInt("acct_num"), result.getDouble("od_limit"));
            } else {
                account = new BankAccount.SavingsAccount(result.getInt("acct_num"), result.getDouble("int_rate"));
            }
            account.setAccountType(result.getString("acct_type"));
            account.setCustomer(customer);  // Set the customer with full name
            account.setAccountNum(result.getInt("acct_num"));
            account.setBalance(result.getDouble("balance"));
            account.setCreateDate(LocalDate.parse(result.getString("create_date"), formatter));
            account.setLastUpdateDate(LocalDate.parse(result.getString("last_update_date"), formatter));
            
            accounts.add(account);
        }
        
        return accounts;
    }
    
    

    
}
