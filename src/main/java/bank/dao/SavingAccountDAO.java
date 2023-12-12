package bank.dao;

import bank.entity.CheckingAccount;
import bank.entity.SavingAccount;
import bank.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
