package com.example;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testTransactionCreation() {
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, new Date(), account);
        assertEquals("T123", transaction.getTransactionId());
        assertEquals(500.0, transaction.getAmount());
        assertEquals(TransactionType.DEPOSIT, transaction.getTransactionType());
    }
}
