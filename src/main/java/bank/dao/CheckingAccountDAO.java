package bank.dao;

import bank.entity.CheckingAccount;
import bank.entity.Customer;
import bank.utils.DBUtil;

import java.io.IOException;
import java.sql.*;

public class CheckingAccountDAO {
    public CheckingAccount getById(int id) {
        String sql = "SELECT * FROM `checking_account` WHERE id = ?";
        CheckingAccount checkingAccount = null;
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double overdraftProtection = resultSet.getDouble(2);
                checkingAccount = new CheckingAccount(overdraftProtection,id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkingAccount;
    }

    public void add(CheckingAccount checkingAccount) {
        String sql = "INSERT INTO `checking_account` VALUES(?,?) ";
        try(Connection connection = DBUtil.getConnection();
            var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,checkingAccount.getId());
            preparedStatement.setDouble(2,checkingAccount.getOverdraftProtection());
            preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int delete(int id) {
        String sql = "DELETE FROM `checking_account` WHERE id = ?";
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
}
