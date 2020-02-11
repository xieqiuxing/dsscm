package cn.dsscm.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import cn.dsscm.pojo.ProductCategory;

public interface ProductCategoryService {
	
	public PageInfo<ProductCategory> findAll(Integer pageNum,Integer pageSize,String queryname,Integer categoryLevel1Id,Integer type);
	/**
	 * 根据ID查询商品分类
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ProductCategory findById(long id) throws SQLException;
	/**
	 * 根据父ID获取子商品分类
	 * @param parentId
	 * @return
	 * @throws SQLException
	 */
	public List<ProductCategory> getProductCategories(Long parentId)
			throws SQLException;
	/**
	 * 查询商品分类的根节点
	 * @return
	 * @throws SQLException
	 */
	public List<ProductCategory> getRootCategories() throws SQLException;
	/**
	 * 删除商品分类
	 * @param parseLong
	 * @throws SQLException
	 */
	public int delete(long pid) throws SQLException;
	/**
	 * 新增商品分类
	 */
	public int save(ProductCategory productCategory) throws SQLException;
	/**
	 * 更新商品分类
	 * @param productCategory
	 * @throws SQLException
	 */
	public int update(ProductCategory productCategory) throws SQLException;
	public List<ProductCategory> findProductCategorys()throws SQLException;
	public int findcount(@Param("name")String name) throws SQLException;
	public int findCountById(@Param("id")Integer id) throws SQLException;
	public long findMaxId(@Param("id")Integer pid) throws SQLException;
}
