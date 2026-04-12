package bank.service;

import java.util.Date;

public class AccountEntryDTO {
    private Date date;
    private double amount;
    private String description;

    public AccountEntryDTO() {
    }

    public AccountEntryDTO(double amount, Date date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
