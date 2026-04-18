package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.email.IEmailSender;
import bank.factory.AbstractFactory;
import bank.factory.FactoryProvider;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
    private IEmailSender emailSender;

	
	public AccountService(){
        AbstractFactory factory = FactoryProvider.getFactory();
        accountDAO = factory.createAccountDAO();
        emailSender = factory.createEmailSender();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);

        emailSender.sendEmail("Deposit of " + amount + " to account " + accountNumber);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);

        emailSender.sendEmail("Withdraw of " + amount + " from account " + accountNumber);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);

        emailSender.sendEmail("Transfer of " + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
	}
}
