package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserCreation() {
        User user = new User("1", "TestUser", "password123", UserType.CUSTOMER);
        assertNotNull(user.getCreationDate());
        assertEquals("TestUser", user.getUsername());
        assertEquals(UserType.CUSTOMER, user.getUserType());
    }

    @Test
    void testAddAccount() {
        User user = new User("1", "TestUser", "password123", UserType.CUSTOMER);
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        user.addAccount(account);
        assertFalse(user.getAccounts().isEmpty());
        assertEquals(1, user.getAccounts().size());
        assertEquals(account, user.getAccounts().get(0));
    }
}
