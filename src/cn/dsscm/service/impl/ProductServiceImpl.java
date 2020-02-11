package cn.dsscm.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dsscm.dao.ProductMapper;
import cn.dsscm.pojo.Product;
import cn.dsscm.service.ProductService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Resource
	private ProductMapper productMapper;
	public Product findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return productMapper.findById(id);
	}

	public PageInfo<Product> getAll(Integer pageNum,Integer pageSize, Long categoryLevel1Id, String name)
			throws SQLException {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Product> list=productMapper.getAll(categoryLevel1Id, name);
		PageInfo<Product> pi=new PageInfo<Product>(list);
		return pi;
	}

	public List<Product> getProductsByCategoryLevelOne(Long id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByCategoryLevelTwo(Long id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByCategoryLevelTwo(Long id, String condition)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int modifyCategoryOfProductBySql(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Long id) throws SQLException {
		return productMapper.delete(id);
		// TODO Auto-generated method stub
		
	}

	public int save(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return productMapper.save(product);
	}

	public int update(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return productMapper.update(product);
	}

	public int updateChildID(int parentid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getProductRowCountByCategoryLevelTwo(Long categoryId)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getProductRowCountByCategoryLevelTwo(Long categoryId,
			String condition) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateStock(Long id, Long quantity) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
