package bank;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.proxy.TimingProxy;
import bank.service.*;


public class Application {
	public static void main(String[] args) {
		IAccountService realService = new AccountService();
        ClassLoader loader = IAccountService.class.getClassLoader();

        IAccountService accountService = (IAccountService) Proxy.newProxyInstance(
                loader,
                new Class[]{IAccountService.class},
                new TimingProxy(realService)
        );
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdraw(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<AccountDTO> accountlist = accountService.getAllAccounts();

		for (AccountDTO account : accountlist) {
			CustomerDTO customerDTO = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customerDTO.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntryDTO entry : account.getEntries()) {
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


