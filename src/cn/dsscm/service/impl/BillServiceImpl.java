package cn.dsscm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.dsscm.dao.BillMapper;
import cn.dsscm.pojo.Bill;
import cn.dsscm.service.BillService;

@Service
public class BillServiceImpl implements BillService{
	@Resource
	private BillMapper billMapper;
	
	public int getBillCountByProviderId(Integer providerId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.add(bill);
	}

	public PageInfo<Bill> getBillList(Integer pageNum,Integer pageSize,String productName, Integer providerId,Integer isPayment) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<Bill> list=billMapper.getBillList(productName, providerId, isPayment);
		PageInfo<Bill> pb=new PageInfo<Bill>(list);
		// TODO Auto-generated method stub
		return pb;
	}

	public int getBillCount(String productName, Integer providerId,
			Integer isPayment) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteBillById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.deleteBillById(delId);
	}

	public Bill getBillById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.getBillById(id);
	}

	public int modify(Bill bill) throws Exception {
		// TODO Auto-generated method stub
		return billMapper.modify(bill);
	}

	public int deleteBillByProviderId(Integer providerId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
