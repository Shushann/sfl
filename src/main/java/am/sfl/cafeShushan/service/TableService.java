package am.sfl.cafeShushan.service;


import am.sfl.cafeShushan.entity.Order;
import am.sfl.cafeShushan.entity.Table;
import am.sfl.cafeShushan.entity.User;

/**
 * Created by Shushi on 1/9/2018.
 */
public interface TableService {
	public Table findByUser(User user);
	void save(Table table);
	Order getOpenOrder(Table table);
}
