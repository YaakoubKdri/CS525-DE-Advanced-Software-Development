package bank.service;

import bank.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
    private long accountNumber;
    private CustomerDTO customer;
    private double balance;
    private List<AccountEntryDTO> entries;

    public AccountDTO() {
        entries = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<AccountEntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<AccountEntryDTO> entries) {
        this.entries = entries;
    }
}
