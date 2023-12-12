package bank.service;

import bank.dao.CheckingAccountDAO;
import bank.dao.CustomerDAO;
import bank.entity.CheckingAccount;
import bank.entity.Customer;

public class CheckingAccountService {
    private CheckingAccountDAO checkingAccountDAO = new CheckingAccountDAO();
    public CheckingAccount getById(int id) {
        return checkingAccountDAO.getById(id);
    }
}
