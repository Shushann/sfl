package am.sfl.cafeShushan.service;

import am.sfl.cafeShushan.entity.ProductInOrder;
import am.sfl.cafeShushan.repository.ProductInOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Shushi on 1/9/2018.
 */
@Service("productInOrderService")
public class ProductInOrderServiceImpl implements ProductInOrderService{

	@Autowired
	private ProductInOrderRepository productInOrderRepository;


	@Override
	public List<ProductInOrder> findAll() {
		return productInOrderRepository.findAll();
	}

	@Override
	public void save(ProductInOrder productInOrder) {
		productInOrderRepository.save(productInOrder);
	}
}
