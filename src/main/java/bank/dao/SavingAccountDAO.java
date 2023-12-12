package bank.dao;

import bank.entity.CheckingAccount;
import bank.entity.SavingAccount;
import bank.utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingAccountDAO {
    public SavingAccount getById(int id) {
        String sql = "SELECT * FROM `saving_account` WHERE id = ?";
        SavingAccount savingAccount = null;
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double balance = resultSet.getDouble(2);
                savingAccount = new SavingAccount(balance,id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savingAccount;
    }

    public void add(SavingAccount savingAccount) {
        String sql = "INSERT INTO `saving_account` VALUES(?,?) ";
        try(Connection connection = DBUtil.getConnection();
            var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,savingAccount.getId());
            preparedStatement.setDouble(2,savingAccount.getBalance());
            preparedStatement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int delete(int id) {
        String sql = "DELETE FROM `saving_account` WHERE id = ?";
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
