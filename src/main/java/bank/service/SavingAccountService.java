package bank.service;
import bank.dao.SavingAccountDAO;
import bank.entity.SavingAccount;

public class SavingAccountService {
    private SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
    public SavingAccount getById(int id) {
        return savingAccountDAO.getById(id);
    }

    public void add(double balance,int id) {
        SavingAccount savingAccount = new SavingAccount(balance,id);
        savingAccountDAO.add(savingAccount);
    }

    public int delete(int id) {
        return savingAccountDAO.delete(id);
    }
}
