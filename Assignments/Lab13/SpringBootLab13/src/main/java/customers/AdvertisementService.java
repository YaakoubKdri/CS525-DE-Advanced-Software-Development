package customers;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {
    @Async
    @EventListener
    public void onEvent(NewCustomerEvent event){
        Customer customer = event.getCustomer();
        System.out.println("AdvertisementService received new customer:" + customer.getName() + " email=" + customer.getEmail());
    }
}
