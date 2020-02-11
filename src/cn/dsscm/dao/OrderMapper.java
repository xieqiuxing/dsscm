package cn.dsscm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dsscm.pojo.Order;
import cn.dsscm.pojo.OrderDetail;
import cn.dsscm.pojo.Product;

public interface OrderMapper {
	/**
	 * 保存订单
	 * @param order
	 * @throws SQLException
	 */
	public int saveOrder(Order order) throws SQLException;
	/**
	 * 保存订单详情
	 * @param detail
	 * @param orderId
	 * @throws SQLException
	 */
	public int saveOrderDetail(OrderDetail detail, int orderId) throws SQLException;
	/**
	 * 删除订单
	 * @param id
	 * @throws SQLException
	 */
	public int deleteOrder(long id) throws SQLException;
	/**
	 * 删除订单详情
	 * @param id
	 * @throws SQLException
	 */
	public int deleteOrderDetails(long id) throws SQLException;
	/**
	 * 根据ID获取订单
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Order findById(int id) throws SQLException;
	/**
	 * 更新订单
	 * @param order
	 * @throws SQLException
	 */
	public int updateOrder(Order order) throws SQLException;
	/**
	 * 获取订单共有多少条记录
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public long getOrderRowCount(String condition) throws SQLException;
	/**
	 * 获取订单及其下属的详情记录
	 * @param condition
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public List<Order> getOrders(@Param("userName")String userName,@Param("status") Integer status,@Param("oid") Integer oid) throws SQLException;

}
