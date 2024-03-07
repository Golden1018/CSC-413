package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class TransactionTest {

    public TransactionTest() {
        // Default constructor
    }

    @Test
    public void testSetUser() {
        // Create a transaction
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, null, null);

        // Create a user
        User user = new User("1", "john_doe", "password", UserType.CUSTOMER);

        // Set the user for the transaction
        transaction.setUser(user);

        // Assert that the user associated with the transaction is the expected user
        assertEquals(user, transaction.getUser());
    }

    @Test
    public void testSetAssociatedAccount() {
        // Create a transaction
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, null, null);

        // Create an account
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);

        // Set the associated account for the transaction
        transaction.setAssociatedAccount(account);

        // Assert that the account associated with the transaction is the expected
        // account
        assertEquals(account, transaction.getAssociatedAccount());
    }

}
