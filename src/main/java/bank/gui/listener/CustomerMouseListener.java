package bank.gui.listener;

import bank.entity.CheckingAccount;
import bank.entity.SavingAccount;
import bank.gui.panel.MainPanel;
import bank.service.CheckingAccountService;
import bank.service.CustomerService;
import bank.service.SavingAccountService;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomerMouseListener implements MouseListener {
    private final JTable table;
    private SavingAccountService savingAccountService = new SavingAccountService();
    private CheckingAccountService checkingAccountService = new CheckingAccountService();
    private CustomerService customerService = new CustomerService();
    public CustomerMouseListener(JTable table) {
        this.table = table;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JTable target = (JTable) e.getSource();
            int row = target.getSelectedRow();
            String name = target.getValueAt(row, 0).toString();
            // 展示信息 利用JOptionPane dialog
            int id = customerService.getId(name);
            SavingAccount savingAccount = savingAccountService.getById(id);
            CheckingAccount checkingAccount = checkingAccountService.getById(id);
            //System.out.println(checkingAccount +  "  " + checkingAccount.getOverdraftProtection());
            String message = "Name: " + name + "\nSavingAccount balance:" + savingAccount.getBalance() +
                    "\nCheckingAccount overdraftProtection:" + checkingAccount.getOverdraftProtection();
            JOptionPane.showMessageDialog(null, message, "客户信息：", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
