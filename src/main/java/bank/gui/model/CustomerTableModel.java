package bank.gui.model;

import bank.entity.Customer;
import bank.service.CustomerService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerTableModel implements TableModel {
    //列名
    private String[] columnNames = new String[] {"Customers List"};
    //行数据
    public List<Customer> customers = new CustomerService().list();

    public CustomerTableModel() throws SQLException, IOException {
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //第一列的值：客户名
        if(columnIndex == 0) return customers.get(rowIndex).getName();
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
