package bank.domain;

import java.util.*;


public class Account {
	long accountnumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;
    Interest interest;
	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
    public Account(long accountNumber, Customer customer, Interest interest) {
        this.accountnumber = accountNumber;
        this.customer = customer;
        this.interest = interest;
    }
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);

	}

    public void calculateInterest() {
        double currentBalance = getBalance();
        double interestAmount = interest.calculateInterest(currentBalance);
        AccountEntry interestEntry = new AccountEntry(
                new Date(),
                interestAmount,
                "Interest",
                "",
                ""
        );

        entryList.add(interestEntry);
    }
    public void setInterest(Interest interest){
        this.interest = interest;
    }
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

}
