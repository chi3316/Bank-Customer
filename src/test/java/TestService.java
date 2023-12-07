import bank.service.CustomerService;
import org.junit.Test;

public class TestService {
    CustomerService customerService =  new CustomerService();
    @Test
    public void testList() {
        System.out.println(customerService.list());
    }
}
