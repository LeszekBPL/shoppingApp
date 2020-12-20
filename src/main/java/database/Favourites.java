package database;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Favourites {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_rate")
    private int rate;

    public Favourites(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }
}
