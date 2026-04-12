package bank.service;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.proxy.LoggingProxy;
import bank.proxy.TimingProxy;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
    private AccountAdapter adapter = new AccountAdapter();

	
	public AccountService(){
		IAccountDAO realDAO=new AccountDAO();
        ClassLoader loader = IAccountDAO.class.getClassLoader();

        IAccountDAO loggingProxy = (IAccountDAO) Proxy.newProxyInstance(
                loader,
                new Class[]{IAccountDAO.class},
                new LoggingProxy(realDAO)
        );

        IAccountDAO timingProxy = (IAccountDAO) Proxy.newProxyInstance(
                loader,
                new Class[]{IAccountDAO.class},
                new TimingProxy(loggingProxy)
        );

        accountDAO = timingProxy;
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
	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return adapter.getAccountDTO(account);
	}

	public Collection<AccountDTO> getAllAccounts() {
        Collection<Account> accounts = accountDAO.getAccounts();
        Collection<AccountDTO> dtos = new ArrayList<>();
        for(Account account : accounts){
            dtos.add(adapter.getAccountDTO(account));
        }
		return dtos;
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
