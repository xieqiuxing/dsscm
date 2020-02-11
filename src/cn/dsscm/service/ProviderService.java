package cn.dsscm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import cn.dsscm.pojo.Provider;

public interface ProviderService {
	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(Provider provider)throws Exception;
	
	/**
	 * 通过条件查询-providerList
	 * @param proName
	 * @param proCode
	 * @return
	 * @throws Exception
	 */
	public PageInfo<Provider> getProviderList(Integer pageNum,Integer pageSize,String proName,String proCode)throws Exception;
	
	/**
	 * 获取供应商列表
	 * @return
	 * @throws Exception
	 */
	public List<Provider> getProList()throws Exception;

	
	
	/**
	 * 通过条件查询-供应商表记录数
	 * @param proName
	 * @param proCode
	 * @return
	 * @throws Exception
	 */
	public int getProviderCount(@Param("proName")String proName,@Param("proCode")String proCode)throws Exception;
	
	/**
	 * 通过供应商id删除供应商信息
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteProviderById(@Param("id")Integer delId)throws Exception; 
	
	/**
	 * 根据provider id 获取供应商信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Provider getProviderById(@Param("id")Integer id)throws Exception; 
	
	/**
	 * 修改供应商
	 * @param provider
	 * @return
	 * @throws Exception
	 */
	public int modify(Provider provider)throws Exception;
}
