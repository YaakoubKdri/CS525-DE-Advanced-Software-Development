package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.email.EmailSender;
import bank.email.IEmailSender;

public class ProductionFactory implements AbstractFactory{
    @Override
    public IAccountDAO createAccountDAO() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender createEmailSender() {
        return EmailSender.getInstance();
    }
}
