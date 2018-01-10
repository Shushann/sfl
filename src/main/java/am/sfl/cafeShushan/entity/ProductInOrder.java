package am.sfl.cafeShushan.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shushi on 1/9/2018.
 */
@Entity
@Data
public class ProductInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany
    private List<Product> products;
}
