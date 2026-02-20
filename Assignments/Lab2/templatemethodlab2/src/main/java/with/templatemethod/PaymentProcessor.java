package with.templatemethod;
public abstract class PaymentProcessor {

    public final void processPayment(double amount, String currency, Customer customer) {
        double finalAmount = convertCurrency(amount, currency);
        validatePayment(customer);
        executePayment(finalAmount);
        notifyCustomer(customer);
    }

    protected double convertCurrency(double amount, String currency) {
        if (currency.equals("EUR")) {
            System.out.println("Convert " + amount + " EUR to US dollars");
            return amount * 1.1;
        }
        if (currency.equals("TND")) {
            System.out.println("Convert " + amount + " TND to US dollars");
            return amount * 0.014;
        }
        return amount;
    }

    protected abstract void validatePayment(Customer customer);
    protected abstract void executePayment(double amount);
    protected abstract void notifyCustomer(Customer customer);
}