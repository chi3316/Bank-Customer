package bank.gui.listener;

import bank.entity.Customer;
import bank.gui.panel.MainPanel;
import bank.service.CustomerService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class CustomerListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取面板
        MainPanel p = MainPanel.instance;
        //业务处理对象service
        CustomerService customerService = new CustomerService();
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
            customerService.delete(id);
        }

        //TODO:完成搜索的逻辑
        if(p.bSearch == b) {

        }

        if(p.bSort == b) {
            //点一下排序，再点一下取消排序
            p.sorted =  p.sorted == true ? false : true;
        }

        p.updateData();//更新表格数据
    }
}
