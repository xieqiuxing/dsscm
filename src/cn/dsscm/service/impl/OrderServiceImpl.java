package cn.dsscm.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dsscm.dao.OrderMapper;
import cn.dsscm.pojo.Order;
import cn.dsscm.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderMapper orderMapper;
	public List<Order> getOrders(String userName, Integer status,Integer oid)
			throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("==========="+orderMapper.getOrders(userName, status,oid));
		return orderMapper.getOrders(userName, status,oid);
	}
	
}
