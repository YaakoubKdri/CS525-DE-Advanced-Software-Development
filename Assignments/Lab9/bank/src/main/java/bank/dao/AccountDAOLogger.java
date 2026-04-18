package bank.dao;

import bank.domain.Account;

import java.util.Collection;
import java.util.List;

public class AccountDAOLogger implements IAccountDAO{
    private IAccountDAO accountDAO;

    public AccountDAOLogger(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Log: saveAccount called for account " + account.getAccountnumber());
        accountDAO.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("Log: updateAccount called for account " + account.getAccountnumber());
        accountDAO.updateAccount(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {
        System.out.println("Log: loadAccount called for account " + accountnumber);
        return accountDAO.loadAccount(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        System.out.println("Log: getAccounts called");
        return accountDAO.getAccounts();
    }
}
