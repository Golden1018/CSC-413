package com.example;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void testAccountCreationAndBalance() {
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        assertEquals(1000.0, account.getBalance());
        assertEquals(AccountType.SAVINGS, account.getAccountType());
    }

    @Test
    void testAddTransaction() {
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, new Date(), account);
        account.addTransaction(transaction);
        assertFalse(account.getTransactions().isEmpty());
        assertEquals(1, account.getTransactions().size());
        assertEquals(transaction, account.getTransactions().get(0));
    }
}
