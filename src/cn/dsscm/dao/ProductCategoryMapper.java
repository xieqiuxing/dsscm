package cn.dsscm.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;


import cn.dsscm.pojo.ProductCategory;


public interface ProductCategoryMapper {

	public List<ProductCategory> findAll(@Param("name")String queryname,@Param("parentId")Integer categoryLevel1Id,@Param("type")Integer type);
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
	public int delete(@Param("pid")long parseLong) throws SQLException;
	/**
	 * 新增商品分类
	 */
	public int save(ProductCategory productCategory) throws SQLException;
	/**
	 * 更新商品分类
	 * @param productCategory
	 * @throws SQLException
	 */
	public List<ProductCategory> findProductCategorys()throws SQLException;
	public int update(ProductCategory productCategory) throws SQLException;
	public int findcount(@Param("name")String name) throws SQLException;
	public int findCountById(@Param("id")Integer id) throws SQLException;
	public long findMaxId(@Param("id")Integer pid) throws SQLException;
}
