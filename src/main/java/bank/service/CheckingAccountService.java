package bank.service;
import bank.dao.CheckingAccountDAO;
import bank.entity.CheckingAccount;

public class CheckingAccountService {
    private CheckingAccountDAO checkingAccountDAO = new CheckingAccountDAO();
    public CheckingAccount getById(int id) {
        return checkingAccountDAO.getById(id);
    }
    public void add(double overdraftProtection,int id) {
        CheckingAccount checkingAccount = new CheckingAccount(overdraftProtection,id);
        checkingAccountDAO.add(checkingAccount);
    }

    public int delete(int id) {
        return checkingAccountDAO.delete(id);
    }
}
