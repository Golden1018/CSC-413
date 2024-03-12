package main.java.com.example;

public class Main {
    public static void main(String[] args) {
        // Create the DAO implementation
        AccountDAO accountDao = new AccountDAOImpl();

        // Create a new account DTO
        AccountDTO newAccount = new AccountDTO(520, "John Doe", 10000.00);
        
        // Add the account using the DAO
        accountDao.create(newAccount);
        
        // Retrieve the account by ID using the DAO
        AccountDTO retrievedAccount = accountDao.get(1);
        
        // Output the retrieved account details
        System.out.println("Retrieved Account Details:");
        System.out.println("ID: " + retrievedAccount.getAccountId());
        System.out.println("Holder: " + retrievedAccount.getAccountHolder());
        System.out.println("Balance: $" + retrievedAccount.getBalance());
        
        // List all accounts
        System.out.println("\nAll Accounts:");
        for (AccountDTO account : accountDao.getAll()) {
            System.out.println("ID: " + account.getAccountId() + ", Holder: " + account.getAccountHolder() + ", Balance: $" + account.getBalance());
        }
    }
}

