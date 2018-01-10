package am.sfl.cafeShushan.entity;

import am.sfl.cafeShushan.model.TableStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shushi on 1/9/2018.
 */
@Entity(name="cafeTable")
@Data
@ToString
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tbl_id")
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "table")
    private List<Order> order;


    @Enumerated(EnumType.STRING)
    private TableStatus tableStatus;
}
