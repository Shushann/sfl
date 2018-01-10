package am.sfl.cafeShushan.service;


import am.sfl.cafeShushan.entity.Order;
import am.sfl.cafeShushan.entity.Table;

/**
 * Created by Shushi on 1/9/2018.
 */
public interface OrderService {
	Order findByTableAndStatus(Table table);
	void save(Order order);

}
