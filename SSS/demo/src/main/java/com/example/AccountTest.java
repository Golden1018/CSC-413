package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AccountTest {

    @Test
    public void testCreateAccount() {
        Account account = new Account(101, 1, 1000);
        assertEquals(1000, account.getBalance(), 0.01);
    }

    @Test
    public void testAddTransactionToAccount() {
        Account account = new Account(101, 1, 1000);
        Transaction transaction = new Transaction(201, account.getAccountID(), "Deposit", 500, "Deposit into account");

        account.addTransaction(transaction);

        assertTrue(account.getTransactions().contains(transaction));
    }
}