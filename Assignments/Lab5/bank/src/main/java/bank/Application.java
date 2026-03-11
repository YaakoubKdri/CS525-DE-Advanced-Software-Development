package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");

        // Scenario from question b
        Account account = accountService.getAccount(1263862);
        System.out.println("\nInitial Balance: " + account.getBalance());

        //deposit
        System.out.println("\n--- Deposit 500 ---");
        accountService.deposit(1263862, 500);
        System.out.println("Balance after deposit: " + accountService.getAccount(1263862).getBalance());

        //withdraw
        System.out.println("\n--- Withdraw 100 ---");
        accountService.withdraw(1263862, 100);
        System.out.println("Balance after withdraw: " + accountService.getAccount(1263862).getBalance());

        //undo
        System.out.println("\n--- Undo last operation ---");
        accountService.undo();
        System.out.println("Balance after undo: " + accountService.getAccount(1263862).getBalance());
	}

}


