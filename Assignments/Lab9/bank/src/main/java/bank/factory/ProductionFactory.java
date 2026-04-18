package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.AccountDAOLogger;
import bank.dao.IAccountDAO;
import bank.email.EmailSender;
import bank.email.IEmailSender;

public class ProductionFactory implements AbstractFactory{
    @Override
    public IAccountDAO createAccountDAO() {
        IAccountDAO dao = new AccountDAO();
        return new AccountDAOLogger(dao);
    }

    @Override
    public IEmailSender createEmailSender() {
        return EmailSender.getInstance();
    }
}
