package bank.gui.listener;

import bank.entity.Customer;
import bank.gui.panel.MainPanel;
import bank.service.CheckingAccountService;
import bank.service.CustomerService;
import bank.service.SavingAccountService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取面板
        MainPanel p = MainPanel.instance;
        //业务处理对象service
        CustomerService customerService = new CustomerService();
        CheckingAccountService checkingAccountService = new CheckingAccountService();
        SavingAccountService savingAccountService = new SavingAccountService();
        //判断用户点击的按钮
        JButton b = (JButton) e.getSource();

        if(p.bAdd == b) {
            //显示文本输入框
            String name = JOptionPane.showInputDialog("请输入新客户名称");
            if(name == null) {
                return;
            }
            if(name.length() == 0) {
                JOptionPane.showMessageDialog(p,"名字不能为空");
                return;
            }
            customerService.add(name);
            Double overdraftProtection = Double.parseDouble(JOptionPane.showInputDialog("请输入客户支票账户的可透支金额："));
            int id = customerService.getId(name);
            checkingAccountService.add(overdraftProtection,id);
            Double balance = Double.parseDouble(JOptionPane.showInputDialog("请输入客户储蓄账户的余额："));
            savingAccountService.add(balance,id);
        }

        if(p.bDelete == b) {
            if(!p.checkSelected()) {
                JOptionPane.showMessageDialog(p,"请先选中一行");
                return;
            }

            Customer selectCustomer = p.getSelectCustomer();
            if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p,"确认删除？")) {
                return;
            }
            int id = selectCustomer.getId();
            checkingAccountService.delete(id);
            savingAccountService.delete(id);
            customerService.delete(id);
        }

        if(p.bSearch == b) {
            // 获取搜索框中的文本
            String searchName = JOptionPane.showInputDialog("请输入要查找的客户名称");
            if(searchName == null) {
                return;
            }
            if(searchName.length() == 0) {
                JOptionPane.showMessageDialog(p,"名字不能为空");
                return;
            }

            // 遍历 JTable 中的记录
            for (int i = 0; i < p.table.getRowCount(); i++) {
                String nameInTable = (String) p.table.getValueAt(i, 0); // 获取表格中的客户名字
                // 如果找到匹配的客户
                if (nameInTable.equals(searchName)) {
                    // 选中这一行，可能需要将选中的行滚动到可见区域
                    p.table.setRowSelectionInterval(i, i);
                    p.table.scrollRectToVisible(p.table.getCellRect(i, 0, true));
                    break;
                }
            }
        }

        if(p.bSort == b) {
            //点一下排序，再点一下取消排序
            p.sorted =  p.sorted == true ? false : true;
        }


        p.updateData();//更新表格数据
    }
}
