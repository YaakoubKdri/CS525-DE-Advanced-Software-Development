package bank.observer;

import bank.domain.Account;

public interface Observer {
    void update(Account account);
}
