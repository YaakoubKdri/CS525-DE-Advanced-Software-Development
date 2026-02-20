package bank.domain;

public class SavingInterest implements Interest{
    @Override
    public double calculateInterest(double balance) {
        if (balance < 1000) {
            return balance * 0.01;
        } else if (balance < 5000) {
            return balance * 0.02;
        } else {
            return balance * 0.04;
        }
    }
}
