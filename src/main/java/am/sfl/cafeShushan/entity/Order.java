package am.sfl.cafeShushan.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by Shushi on 1/9/2018.
 */
@Entity(name = "cafeOrder")
@Data
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;
    private String status;
    @ManyToOne
    private Table table;

    private int bill;
    @OneToOne
    @Cascade(CascadeType.ALL)
    private ProductInOrder productInOrder;
}
