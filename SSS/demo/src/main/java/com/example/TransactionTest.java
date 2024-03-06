package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TransactionTest {

    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction(201, 101, "Deposit", 500, "Deposit into account");
        assertEquals("Deposit", transaction.getTransactionType());
    }
}
