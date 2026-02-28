package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.observer.EmailSender;
import bank.observer.Logger;
import bank.observer.SMSSender;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountService();

        Logger logger = new Logger();
        SMSSender smsSender = new SMSSender();
        EmailSender emailSender = new EmailSender();

        accountService.addObserver(emailSender);
//        accountService.addObserver(smsSender);
//        accountService.addObserver(logger);
        // create 2 accounts;
		Account account1 = accountService.createAccount(1263862, "Frank Brown");
        Account account2 = accountService.createAccount(4253892, "John Doe");

        // observers
        account1.addObserver(logger);
        account1.addObserver(smsSender);

        account2.addObserver(logger);
        account2.addObserver(smsSender);


		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


