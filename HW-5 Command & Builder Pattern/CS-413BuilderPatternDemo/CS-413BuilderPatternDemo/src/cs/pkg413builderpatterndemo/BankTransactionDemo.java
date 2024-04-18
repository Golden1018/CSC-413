package cs.pkg413builderpatterndemo;

import java.util.Date;

interface TransactionInterface {
    void execute();
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient funds");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}

class DepositTransaction implements TransactionInterface {
    private BankAccount account;
    private double amount;

    public DepositTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void execute() {
        account.deposit(amount);
    }
}

class WithdrawTransaction implements TransactionInterface {
    private BankAccount account;
    private double amount;

    public WithdrawTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void execute() {
        try {
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class BankAccountTransaction {
    private String id;
    private Date dateTime;
    private String type;
    private double amount;
    private String description;
    private TransactionInterface transaction;

    public BankAccountTransaction(String id, Date dateTime, String type, double amount, String description) {
        this.id = id;
        this.dateTime = dateTime;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public void setTransaction(TransactionInterface transaction) {
        this.transaction = transaction;
    }

    public void executeTransaction() {
        transaction.execute();
    }
}

public class BankTransactionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0);
        BankAccountTransaction tx = new BankAccountTransaction("TX100", new Date(), "Deposit", 500,
                "Deposit to savings");

        tx.setTransaction(new DepositTransaction(account, 500));
        tx.executeTransaction();

        tx.setTransaction(new WithdrawTransaction(account, 200));
        tx.executeTransaction();

        System.out.println("Final Balance: " + account.getBalance());
    }
}
