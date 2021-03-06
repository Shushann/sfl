package am.sfl.cafeShushan.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shushi on 1/9/2018.
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @Column(unique = true)
    private String name;

    private int price;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<ProductInOrder> productInOrders;

}
