package with.templatemethod;

public class PaypalPaymentProcessor extends PaymentProcessor {

    private String paypalAddress;

    public PaypalPaymentProcessor(String paypalAddress) {
        this.paypalAddress = paypalAddress;
    }

    @Override
    protected void validatePayment(Customer customer) {
        System.out.println("Validate paypal address " + paypalAddress);
    }

    @Override
    protected void executePayment(double amount) {
        System.out.println("Perform payment with paypal address " + paypalAddress + " and amount $" + amount);
    }

    @Override
    protected void notifyCustomer(Customer customer) {
        System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail() + " about paypal payment to address " + paypalAddress);
    }
}