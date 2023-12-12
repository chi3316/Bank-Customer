package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount {
    private double balance;
    private int id;
    public SavingAccount(double balance) {
        this.balance = balance;
    }
}
