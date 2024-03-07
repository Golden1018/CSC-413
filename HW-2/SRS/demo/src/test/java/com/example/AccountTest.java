package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

    public AccountTest() {
        // Default constructor
    }

    @Test
    public void testSetUser() {
        // Create an account
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);

        // Create a user
        User user = new User("1", "john_doe", "password", UserType.CUSTOMER);

        // Set the user for the account
        account.setUser(user);

        // Assert that the user associated with the account is the expected user
        assertEquals(user, account.getUser());
    }

    @Test
    public void testAddTransaction() {
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, null, account);

        account.addTransaction(transaction);

        assertTrue(account.getTransactions().contains(transaction));
        assertEquals(account, transaction.getAssociatedAccount());
    }
}
