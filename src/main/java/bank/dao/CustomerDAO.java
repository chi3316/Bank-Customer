package bank.dao;
import bank.entity.Customer;
import bank.utils.DBUtil;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久层，对数据库表costumer进行增删改查
 */
public class CustomerDAO {
    public void add(Customer customer) {
        String sql = "INSERT INTO customers(name) VALUES(?) ";
        try(Connection connection = DBUtil.getConnection();
            var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            preparedStatement.setString(1,customer.getName());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                int id = rs.getInt(2);
                customer.setId(id);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int delete(int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        int res = 0;
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1,id);
            res = preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Customer getById(int id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        Customer customer = null;
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name =  resultSet.getString(1);
                customer = new Customer(name,id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     * 展示start - counts条记录
     * @param start
     * @param counts
     * @return
     */
    public List<Customer> list(int start, int counts) {
        String sql = "SELECT * FROM customers ORDER BY id LIMIT ?,?";
        List<Customer> lists = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,counts);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getString(1),resultSet.getInt(2));
                lists.add(customer);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return lists;
    }

    public List<Customer> list() {
        return list(0,Integer.MAX_VALUE);
    }
}
