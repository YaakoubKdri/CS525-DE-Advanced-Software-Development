package bank.observer;

import bank.domain.Account;

public class EmailSender implements Observer{
    @Override
    public void update(Account account) {
        String str = "Email: Account " + account.getAccountnumber() + " balance changed. New balance: " + account.getBalance();
        sendEmail(str);
    }
    public void sendEmail(String str){
        System.out.println(str);
    }
}
