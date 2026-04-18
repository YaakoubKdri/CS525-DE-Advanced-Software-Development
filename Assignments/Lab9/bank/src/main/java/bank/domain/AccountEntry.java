package bank.domain;

import java.util.Date;

public class AccountEntry {
	private Date date;
	private double amount;
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;
	
	private AccountEntry() {
	}

	public static class Builder{
        private Date date;
        private double amount;
        private String description;
        private String fromAccountNumber = "";
        private String fromPersonName = "";

        public Builder withDate(Date date){
            this.date = date;
            return this;
        }
        public Builder withAmount(double amount){
            this.amount = amount;
            return this;
        }
        public Builder withDescription(String description){
            this.description = description;
            return this;
        }
        public Builder fromAccountNumber(String fromAccountNumber){
            this.fromAccountNumber = fromAccountNumber;
            return this;
        }
        public Builder fromPersonName(String fromPersonName){
            this.fromPersonName = fromPersonName;
            return this;
        }
        public AccountEntry build(){
            AccountEntry entry = new AccountEntry();
            entry.date = this.date;
            entry.amount = this.amount;
            entry.description = this.description;
            entry.fromAccountNumber = this.fromAccountNumber;
            entry.fromPersonName = this.fromPersonName;
            return entry;
        }
    }

	public double getAmount() {
		return amount;
	}
	public Date getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public String getFromPersonName() {
		return fromPersonName;
	}
}
