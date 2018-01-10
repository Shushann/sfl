package am.sfl.cafeShushan.service;

import am.sfl.cafeShushan.entity.Order;
import am.sfl.cafeShushan.entity.Table;
import am.sfl.cafeShushan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Shushi on 1/9/2018.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;


	@Override
	public Order findByTableAndStatus(Table table) {
		Order order = orderRepository.findByTableAndStatus(table);
		return order;
	}

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}
}
