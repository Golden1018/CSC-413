package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testAddAccount() {
        User user = new User("1", "john_doe", "password123", UserType.CUSTOMER);
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, null, null);

        user.addAccount(account);
        account.addTransaction(transaction);

        assertTrue(user.getAccounts().contains(account));
        assertTrue(account.getTransactions().contains(transaction));
        assertEquals(user, account.getUser());
        assertEquals(account, transaction.getAssociatedAccount());
    }

    @Test
    public void testAddTransaction() {
        User user = new User("1", "john_doe", "password123", UserType.CUSTOMER);
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, null, null);

        user.addTransaction(transaction);
        account.addTransaction(transaction);

        assertTrue(user.getTransactions().contains(transaction));
        assertTrue(account.getTransactions().contains(transaction));
        assertEquals(user, transaction.getUser());
        assertEquals(account, transaction.getAssociatedAccount());
    }
}
