package bank.command;

import bank.domain.Account;

public class TransferFundsCommand implements Command{
    private Account fromAccount;
    private Account toAccount;
    private double amount;
    private String description;

    public TransferFundsCommand(Account fromAccount, Account toAccount, double amount, String description) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        fromAccount.transferFunds(toAccount, amount, description);
    }

    @Override
    public void unExecute() {
        toAccount.withdraw(amount);
        fromAccount.deposit(amount);
    }
}
