package bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private int id;
    public Customer(String name) {
        this.name = name;
    }
}
