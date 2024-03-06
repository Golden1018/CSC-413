package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer(1, "John", "Doe", "john@example.com", "123-456-7890");
        assertEquals("John", customer.getFirstName());
    }

    @Test
    public void testAddAccountToCustomer() {
        Customer customer = new Customer(1, "John", "Doe", "john@example.com", "123-456-7890");
        Account account = new Account(101, customer.getCustomerID(), 1000);
        
        customer.addAccount(account);
        
        assertTrue(customer.getAccounts().contains(account));
    }
}
