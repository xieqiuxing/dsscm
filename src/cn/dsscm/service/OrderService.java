package cn.dsscm.service;

import java.sql.SQLException;
import java.util.List;

import cn.dsscm.pojo.Order;

public interface OrderService {
	public List<Order> getOrders(String userName,Integer status,Integer oid) throws SQLException;
}
