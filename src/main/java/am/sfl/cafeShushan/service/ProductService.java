package am.sfl.cafeShushan.service;


import am.sfl.cafeShushan.entity.Product;

import java.util.List;

/**
 * Created by Shushi on 1/9/2018.
 */
public interface ProductService {
	List<Product> findAll();
	Product findByName(String name);
	void save(Product product);
	Product findById(Long id);
}
