package database;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private int id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_amount")
    private int amount;

    public ShoppingList(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
