package bank.service;
import bank.dao.SavingAccountDAO;
import bank.entity.SavingAccount;

public class SavingAccountService {
    private SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
    public SavingAccount getById(int id) {
        return savingAccountDAO.getById(id);
    }
}
