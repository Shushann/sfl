package am.sfl.cafeShushan.service;

import am.sfl.cafeShushan.entity.Order;
import am.sfl.cafeShushan.entity.Table;
import am.sfl.cafeShushan.entity.User;
import am.sfl.cafeShushan.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Shushi on 1/9/2018.
 */
@Service("tableService")
public class TableServiceImpl implements TableService{

	@Autowired
	private TableRepository tableRepository;


	
	@Override
	public Table findByUser(User user) {
		return tableRepository.findByUser(user);
	}

	@Override
	public void save(Table table) {
		tableRepository.save(table);
	}

	@Override
	public Order getOpenOrder(Table table) {
		List<Order> orders = table.getOrder();
		for (Order or : orders) {
			if (or.getStatus().equals("open")) {
				return  or;
			}
		}
		return null;
	}


}
