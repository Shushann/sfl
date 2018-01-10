package am.sfl.cafeShushan.service;


import am.sfl.cafeShushan.entity.ProductInOrder;

import java.util.List;

/**
 * Created by Shushi on 1/9/2018.
 */
public interface ProductInOrderService {
	List<ProductInOrder> findAll();
	void save(ProductInOrder productInOrder);
}
