package bank.gui.model;

import bank.entity.Customer;
import bank.service.CustomerService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;
/**
 * CustomerPanel 的 Table 的数据模型，实现了 TableModel 接口
 * 将不同的数据源（例如数据库结果集、集合、数组等）与表格组件关联起来，以便在表格中显示和操作数据。
 */
public class CustomerTableModel implements TableModel {
    //列名
    private String[] columnNames = new String[] {"Customers List"};
    //行数据
    public List<Customer> customers = new CustomerService().list();

    public CustomerTableModel()  {
    }

//    public int getSelectedRowId(int rowIndex, int columnIndex) {
//        if(columnIndex == 0) return customers.get(rowIndex).getId();
//    }

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
        //if(columnIndex == 0) return customers.get(rowIndex);
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
