package cn.dsscm.service;

import java.sql.SQLException;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.dsscm.pojo.Product;

public interface ProductService {
	/**
	 * 根据ID查询商品
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Product findById(Long id) throws SQLException;
	/**
	 * 根据一级分类和name查询商品
	 * @param categoryLevel1Id
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public PageInfo<Product> getAll(Integer pageNum,Integer pageSize,Long categoryLevel1Id,String name) throws SQLException;
	/**
	 * 根据分类查询商品
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Product> getProductsByCategoryLevelOne(Long id) throws SQLException;
	/**
	 * 根据分类查询本页显示的商品
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<Product> getProductsByCategoryLevelTwo(Long id)
			throws SQLException;
	/**
	 * 根据分类查询本页显示的商品且带条件查询
	 * @param id
	 * @param currentPageNo
	 * @return
	 * @throws SQLException
	 */
	public List<Product> getProductsByCategoryLevelTwo(Long id,String condition)
			throws SQLException;
	/**
	 * 更新某款商品的分类
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	
	public int modifyCategoryOfProductBySql(String sql) throws SQLException;
	/**
	 * 删除一款商品
	 * @param id
	 * @throws SQLException
	 */
	public int delete(Long id) throws SQLException;
	/**
	 * 保存一款商品
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public int save(Product product) throws SQLException;
	/**
	 * 更新一款商品
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public int update(Product product) throws SQLException;
	/**
	 * 更新商品的二级分类
	 * @param parentid
	 * @return
	 * @throws SQLException
	 */
	public int updateChildID(int parentid) throws SQLException;
	
	/**
	 * 查询所有商品记录数
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 */
	public long getProductRowCountByCategoryLevelTwo(Long categoryId) throws SQLException;
	 
	/**
	 * 查询带条件的商品记录数
	 * @param categoryId
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public long getProductRowCountByCategoryLevelTwo(Long categoryId,String condition ) throws SQLException;
	/**
	 * 更新价格
	 * @param id
	 * @param quantity
	 * @return
	 * @throws SQLException
	 */
	public int updateStock(Long id, Long quantity) throws SQLException;
}
