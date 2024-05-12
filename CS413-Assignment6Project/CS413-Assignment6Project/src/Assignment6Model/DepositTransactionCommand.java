/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Model;

/**
 *
 * @author karunmehta
 */
class DepositTransactionCommand extends BankAccountTransaction implements TransactionInterface {
    
    private final BankAccount account;
    private final double amount;

    public DepositTransactionCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }

}
