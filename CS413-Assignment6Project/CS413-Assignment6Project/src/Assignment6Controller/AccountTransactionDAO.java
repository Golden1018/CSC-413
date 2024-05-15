/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Model.*;

import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karunmehta
 */

public class AccountTransactionDAO implements DAOInterface<BankAccountTransaction> {
    private static AccountTransactionDAO instance;
    private static Connection connection;
    private PreparedStatement pStatement;
    private ResultSet result;
    
    
    public AccountTransactionDAO() {

            connection = DataConnection.getDBConnection();      

    }

    public static AccountTransactionDAO getInstance() {
        if (instance == null) {
            instance = new AccountTransactionDAO();
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
    public int create(BankAccountTransaction at) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(TransactionDataConnection.getInsert());
        pStatement.setTimestamp(1, at.getCreateDate());
        pStatement.setString(2, at.getType());
        pStatement.setDouble(3, at.getAmount());
        pStatement.setString(4, at.getDescription());
        pStatement.setInt(5, at.id());
      
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a uscustomeraddress from the database by ID
    @Override
    public BankAccountTransaction get(int acctID) throws SQLException {

        pStatement = connection.prepareStatement(AccountDataConnection.getSelect());
        pStatement.setInt(1,acctID);
        result = pStatement.executeQuery();
        
        BankAccountTransaction at = null;
        if (result.next()) {
            at = new BankAccountTransaction();
            at.setCreateDate(result.getTimestamp("create_date"));
            at.setType(result.getString("tran_type"));
            at.setAmount(result.getDouble("amount"));
            at.setDescription(result.getString("summary"));
            at.setID(result.getInt("acct_id"));
        }

        return at;
    }

    // Updating transaction not allowed
    @Override
    public int update(BankAccountTransaction t) throws SQLException {
        
        System.out.println("Once created, cannot update transaction for an account");
        
        return -1;
    }

    // Deleting transaction not allowed
    @Override
    public int delete(BankAccountTransaction t) throws SQLException {
        
        System.out.println("Once created, cannot delete transaction for an account");
        
        return -1;
    }

    public List<BankAccountTransaction> findTransactions(String accountId) throws SQLException {
        List<BankAccountTransaction> transactions = new ArrayList<>();
        try {
            String query = "SELECT * FROM account_transaction WHERE acct_id = ?";
            try (Connection connection = DriverManager.getConnection("your-db-url", "username", "password");
                 PreparedStatement pStatement = connection.prepareStatement(query)) {
                pStatement.setString(1, accountId);
                try (ResultSet resultSet = pStatement.executeQuery()) {
                    while (resultSet.next()) {
                        BankAccountTransaction transaction = new BankAccountTransaction();
                        transaction.setCreateDate(resultSet.getTimestamp("create_date"));
                        transaction.setType(resultSet.getString("tran_type"));
                        transaction.setAmount(resultSet.getDouble("amount"));
                        transaction.setDescription(resultSet.getString("summary"));
                        transaction.setID(resultSet.getInt("acct_id"));
                        transactions.add(transaction);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching transactions: " + e.getMessage());
            // Optionally log the error or handle it as needed
        }
        return transactions; // Could be empty if there was an exception
    }
    
    
    

    
}

