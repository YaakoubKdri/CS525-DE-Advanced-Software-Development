package customers;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CustomerRatingService {
    @Async
    @EventListener
    public void onEvent(NewCustomerEvent event){
        Customer customer = event.getCustomer();
        System.out.println("CustomerRatingService received new customer:" + customer.getName() + " email=" + customer.getEmail());

    }
}
