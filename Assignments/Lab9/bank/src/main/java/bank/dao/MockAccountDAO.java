package bank.dao;

import bank.domain.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockAccountDAO implements IAccountDAO{
    private Map<Long, Account> accounts = new HashMap<>();

    @Override
    public void saveAccount(Account account) {
        accounts.put(account.getAccountnumber(), account);
        System.out.println("MockAccountDAO: saveAccount called");
    }

    @Override
    public void updateAccount(Account account) {
        accounts.put(account.getAccountnumber(), account);
        System.out.println("MockAccountDAO: updateAccount called");
    }

    @Override
    public Account loadAccount(long accountnumber) {
        System.out.println("MockAccountDAO: loadAccount called");
        return accounts.get(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        System.out.println("MockAccountDAO: getAccounts called");
        return accounts.values();
    }
}
