package am.sfl.cafeShushan.repository;

import am.sfl.cafeShushan.entity.Order;
import am.sfl.cafeShushan.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Shushi on 1/9/2018.
 */

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {
	 Order findById(Long id);

	@Query("SELECT o FROM cafeOrder o WHERE o.table = :table and o.status = 'open'")
	 Order findByTableAndStatus(@Param("table") Table table);
}
