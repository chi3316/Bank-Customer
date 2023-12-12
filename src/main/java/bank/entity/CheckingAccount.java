package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckingAccount {
    private double overdraftProtection;
    private int id;
    public CheckingAccount(double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }
}
