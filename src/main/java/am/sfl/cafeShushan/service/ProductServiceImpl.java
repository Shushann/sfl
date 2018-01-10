package am.sfl.cafeShushan.service;

import am.sfl.cafeShushan.entity.Product;
import am.sfl.cafeShushan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Shushi on 1/9/2018.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;


	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}
	@Override
	public Product findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}
}
