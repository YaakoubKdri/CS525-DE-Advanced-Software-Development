package customers;

public class NewCustomerEvent {
    Customer customer;

    public NewCustomerEvent(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
