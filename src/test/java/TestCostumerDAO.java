import bank.dao.CustomerDAO;
import bank.entity.Customer;
import org.junit.Test;

import java.util.List;

public class TestCostumerDAO {
    CustomerDAO customerDAO = new CustomerDAO();
    @Test
    public void testAdd() {
        Customer customer = new Customer("David Tao");
        customerDAO.add(customer);
    }

    @Test
    public void testDelete() {
        customerDAO.delete(5);
    }

    @Test
    public void testGetById() {
        Customer customer = customerDAO.getById(1);
        System.out.println(customer);
    }

    @Test
    public void testList() {
        List<Customer> list = customerDAO.list();
        System.out.println(list);
    }
}
