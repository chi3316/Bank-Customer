package bank.gui.panel;

import bank.gui.listener.CustomerListener;
import bank.gui.model.CustomerTableModel;
import bank.service.CustomerService;
import bank.utils.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainPanel extends JPanel {
    public static MainPanel instance;

    static {
        try {
            instance = new MainPanel();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel buttonPanel = new JPanel();
    public JButton bAdd = new JButton();
    public JButton bDelete = new JButton();
    public JButton bSearch = new JButton();
    public JButton bSort = new JButton();

    //将表格 table 关联到数据模型 ctm 上
    private CustomerTableModel ctm = new CustomerTableModel();
    private JTable table = new JTable(ctm);

    private MainPanel() throws SQLException, IOException {
        GuiUtil.setImageIcon(bAdd, "home.png", "添加");
        GuiUtil.setImageIcon(bDelete, "record.png", "删除");
        GuiUtil.setImageIcon(bSearch, "history.png", "查找");
        GuiUtil.setImageIcon(bSort, "report.png", "排序");

        buttonPanel.add(bAdd);
        buttonPanel.add(bDelete);
        buttonPanel.add(bSearch);
        buttonPanel.add(bSort);

        JScrollPane jsp = new JScrollPane(table);

        this.setLayout(new BorderLayout());
        this.add(jsp,BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        addListeners();
    }
    public static void main(String[] args) {
        GuiUtil.showPanel(MainPanel.instance,1);
    }

    public void addListeners() {
        CustomerListener listener = new CustomerListener();
        bAdd.addActionListener(listener);
        bDelete.addActionListener(listener);
        bSearch.addActionListener(listener);
        bSort.addActionListener(listener);
    }

    //实时跟新表格数据
    public void updateData()  {
        ctm.customers = new CustomerService().list();
        table.updateUI();
    }
}
