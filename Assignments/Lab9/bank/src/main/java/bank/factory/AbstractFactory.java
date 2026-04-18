package bank.factory;

import bank.dao.IAccountDAO;
import bank.email.IEmailSender;

public interface AbstractFactory {
    IAccountDAO createAccountDAO();
    IEmailSender createEmailSender();
}
