package cn.dsscm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dsscm.dao.ProviderMapper;
import cn.dsscm.pojo.Provider;
import cn.dsscm.service.ProviderService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ProviderServiceImpl implements ProviderService{
	@Resource
	private ProviderMapper providerMapper;
	public int add(Provider provider) throws Exception {
		// TODO Auto-generated method stub
		return providerMapper.add(provider);
	}

	public PageInfo<Provider> getProviderList(Integer pageNum,Integer pageSize,String proName, String proCode)
			throws Exception {
		// TODO Auto-generated method stub
		//Object[]params={pageNum,pageSize,proName,proCode};
		//开启分页
		PageHelper.startPage(pageNum, pageSize);
//		if(pageNum<0){
//			pageNum=1;
//		}
//		PageHelper.startPage(params);
		//查询结果
		List<Provider>list= providerMapper.getProviderList(proName, proCode);
		PageInfo<Provider> pi=new PageInfo<Provider>(list);
		return pi;
	}

	public List<Provider> getProList() throws Exception {
		// TODO Auto-generated method stub
		return providerMapper.getProList();
	}

	public int getProviderCount(String proName, String proCode)
			throws Exception {
		// TODO Auto-generated method stub
		return providerMapper.getProviderCount(proName, proCode);
	}

	public int deleteProviderById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		return providerMapper.deleteProviderById(delId);
	}

	public Provider getProviderById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return providerMapper.getProviderById(id);
	}

	public int modify(Provider provider) throws Exception {
		// TODO Auto-generated method stub
		return providerMapper.modify(provider);
	}

}
