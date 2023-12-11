package bank.gui.panel;
import bank.entity.Customer;
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
    public boolean sorted = false;
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
    public JTable table = new JTable(ctm);

    private MainPanel() throws SQLException, IOException {
        GuiUtil.setImageIcon(bAdd, "add-user.png", "添加");
        GuiUtil.setImageIcon(bDelete, "delete.png", "删除");
        GuiUtil.setImageIcon(bSearch, "search.png", "查找");
        GuiUtil.setImageIcon(bSort, "sort.png", "排序");

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
        if(!sorted) ctm.customers = new CustomerService().list();
        else ctm.customers = new CustomerService().listSorted();
        table.updateUI();
    }

    //判断用户是否选中表格
    public boolean checkSelected() {
        return table.getSelectedRow() >= 0;
    }

    public Customer getSelectCustomer() {
        int index = table.getSelectedRow();
        return ctm.getCustomers().get(index > 0 ? index : 0);
    }
}
