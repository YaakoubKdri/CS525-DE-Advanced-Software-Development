package bank.factory;

import bank.dao.AccountDAOLogger;
import bank.dao.IAccountDAO;
import bank.dao.MockAccountDAO;
import bank.email.IEmailSender;
import bank.email.MockEmailSender;

public class TestFactory implements AbstractFactory{
    @Override
    public IAccountDAO createAccountDAO() {
        IAccountDAO dao = new MockAccountDAO();
        return new AccountDAOLogger(dao);
    }

    @Override
    public IEmailSender createEmailSender() {
        return new MockEmailSender();
    }
}
