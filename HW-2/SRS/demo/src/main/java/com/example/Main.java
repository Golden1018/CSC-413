package com.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Example usage
        CustomPriorityQueue<PriorityComparable> customQueue = new CustomPriorityQueue<>();

        // Creating objects
        User user = new User("1", "Hsin Ying", "password123", UserType.CUSTOMER);
        Account account = new Account("12345", AccountType.SAVINGS, 1000.0, AccountStatus.ACTIVE);
        Transaction transaction = new Transaction("T123", TransactionType.DEPOSIT, 500.0, new Date(), account);

        // Enqueue objects
        customQueue.enqueue(user);
        customQueue.enqueue(account);
        customQueue.enqueue(transaction);

        // Dequeue objects based on priority
        while (!customQueue.isEmpty()) {
            PriorityComparable dequeuedItem = customQueue.dequeue();
            System.out.println("Dequeued: " + dequeuedItem);
        }
    }
}