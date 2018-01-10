package am.sfl.cafeShushan.repository;

import am.sfl.cafeShushan.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shushi on 1/9/2018.
 */

@Repository("productInOrderRepository")
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {
	 ProductInOrder findById(Long id);
}
