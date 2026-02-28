package bank.observer;

import bank.domain.Account;

public class SMSSender implements Observer{
    @Override
    public void update(Account account) {
        String str = "SMS: Account " + account.getAccountnumber() + " balance changed. New balance: " + account.getBalance();
        sendSMS(str);
    }
    public void sendSMS(String str){
        System.out.println(str);
    }
}
