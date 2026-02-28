package bank.observer;

import bank.domain.Account;

public class Logger implements Observer{
    @Override
    public void update(Account account) {
        String str = "Logger: Account " + account.getAccountnumber() + " balance changed. New balance: " + account.getBalance();
        log(str);
    }
    public void log(String str){
        System.out.println(str);
    }
}
