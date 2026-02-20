package with.templatemethod;

public class VisaPaymentProcessor extends PaymentProcessor {

    private VisaCard visaCard;

    public VisaPaymentProcessor(VisaCard visaCard) {
        this.visaCard = visaCard;
    }

    @Override
    protected void validatePayment(Customer customer) {
        System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
    }

    @Override
    protected void executePayment(double amount) {
        System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber() + " and amount $" + amount);
    }

    @Override
    protected void notifyCustomer(Customer customer) {
        System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail() + " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
        System.out.println("---------------------------------------------------------");
    }
}
