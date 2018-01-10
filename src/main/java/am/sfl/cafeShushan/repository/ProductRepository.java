package am.sfl.cafeShushan.repository;

import am.sfl.cafeShushan.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Shushi on 1/9/2018.
 */
@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
	 Product findById(Long id);
Product findByName(String name);
}
