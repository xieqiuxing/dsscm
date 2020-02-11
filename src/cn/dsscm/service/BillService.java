package cn.dsscm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.dsscm.pojo.Bill;

public interface BillService {
	/**
	 * 根据供应商ID查询订单数量
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	public int getBillCountByProviderId(Integer providerId)throws Exception;


	/**
	 * 增加订单
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public int add(Bill bill)throws Exception;


	/**
	 * 通过查询条件获取供应商列表-getBillList
	 * @param productName
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	public PageInfo<Bill> getBillList(Integer pageNum,Integer pageSize,String productName,Integer providerId,Integer isPayment)throws Exception;
	
	/**
	 * 通过条件查询-订单表记录数
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public int getBillCount(String productName,Integer providerId,Integer isPayment)throws Exception;
	
	/**
	 * 通过delId删除Bill
	 * @param connection
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteBillById(Integer delId)throws Exception; 
	
	
	/**
	 * 通过billId获取Bill
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Bill getBillById(Integer id)throws Exception; 
	
	/**
	 * 修改订单信息
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public int modify(Bill bill)throws Exception;
	
	/**
	 * 根据供应商ID删除订单信息
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	public int deleteBillByProviderId(Integer providerId)throws Exception;

}
