package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    
    @Test
    void testUserCreation() {
        User user = new User("1", "John Doe", "password123", UserType.CUSTOMER);
        assertNotNull(user.getCreationDate());
        assertEquals("John Doe", user.getUsername());
        assertEquals(UserType.CUSTOMER, user.getUserType());
    }

    @Test
    void testAddAccount() {
        User user = new User("1", "John Doe", "password123", UserType.CUSTOMER);
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        user.addAccount(account);
        assertEquals(1, user.getAccounts().size());
        assertEquals(account, user.getAccounts().get(0));
    }

    @Test
    void testFetchUserData() {
        User user = new User("1", "John Doe", "password123", UserType.CUSTOMER);
        UserData userData = user.fetchUserData();
        assertEquals("1", userData.getUserId());
        assertEquals("John Doe", userData.getUsername());
        assertEquals(UserType.CUSTOMER, userData.getUserType());
    }
}