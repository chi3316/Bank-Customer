package bank.service;

import bank.dao.CustomerDAO;
import bank.entity.Customer;

import java.util.Arrays;
import java.util.List;

/**
 * Service层，通过调用DAO层来执行业务的操作逻辑
 */
public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();
    public void add(String name) {
        customerDAO.add(name);
    }

    public int delete(int id) {
        return customerDAO.delete(id);
    }

    public Customer getById(int id) {
        return customerDAO.getById(id);
    }

    public List<Customer> list() {
        return customerDAO.list();
    }

    public List<Customer> listSorted() {
        List<Customer> customers = customerDAO.list();
        customers.sort((c1, c2) -> c1.getName().toUpperCase().compareTo(c2.getName().toUpperCase()));
        return customers;
    }
}
