/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Model;

/**
 *
 * @author karunmehta
 */
class TransferTransactionCommand extends BankAccountTransaction implements TransactionInterface {
    
    private final BankAccount sourceAccount;
    private final BankAccount targetAccount;
    private final double amount;

    public TransferTransactionCommand(BankAccount sAccount, BankAccount tAccount, double amount) {
        
        this.sourceAccount = sAccount;
        this.targetAccount = tAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        sourceAccount.transfer(targetAccount, amount);
    }
}
    