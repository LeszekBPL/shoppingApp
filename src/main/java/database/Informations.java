package database;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Informations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "search_id")
    private int id;
    @Column
    private long code;
    @Column
    private String brands;
    @Column
    private String product_name;
    @Column
    private String categories;
    @Column
    private String countries;
    @Column
    private String stores;
    @Column
    private String purchase_places;

    public Informations(long code, String brands, String product_name, String categories, String countries, String stores, String purchase_places) {
        this.code = code;
        this.brands = brands;
        this.product_name = product_name;
        this.categories = categories;
        this.countries = countries;
        this.stores = stores;
        this.purchase_places = purchase_places;
    }

}
