package com.example;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue of Accounts
        PriorityQueue<Account> accountPriorityQueue = new PriorityQueue<>();

        // Add some sample accounts
        Account account1 = new Account(1, 101, 1000);
        Account account2 = new Account(2, 102, 1500);
        Account account3 = new Account(3, 103, 1200);

        accountPriorityQueue.add(account1);
        accountPriorityQueue.add(account2);
        accountPriorityQueue.add(account3);

        // Access the account with the highest priority (based on creation date and then balance)
        Account highestPriorityAccount = accountPriorityQueue.poll();

        System.out.println("Highest Priority Account ID: " + highestPriorityAccount.getAccountID());
    }
}
