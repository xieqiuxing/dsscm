package cn.dsscm.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dsscm.dao.ProductCategoryMapper;
import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.service.ProductCategoryService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Resource
	private ProductCategoryMapper pcm;

	public ProductCategory findById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductCategory> getProductCategories(Long parentId)
			throws SQLException {
		// TODO Auto-generated method stub
		return pcm.getProductCategories(parentId);
	}

	public List<ProductCategory> getRootCategories() throws SQLException {
		// TODO Auto-generated method stub
		return pcm.getRootCategories();
	}

	public int delete(long pid) throws SQLException {
		// TODO Auto-generated method stub
		return pcm.delete(pid);
	}

	public int save(ProductCategory productCategory) throws SQLException {
		// TODO Auto-generated method stub
		return pcm.save(productCategory);
	}

	public int update(ProductCategory productCategory) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageInfo<ProductCategory> findAll(Integer pageNum,Integer pageSize,String queryname,
			Integer categoryLevel1Id, Integer type) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<ProductCategory> list=pcm.findAll(queryname, categoryLevel1Id, type);
		PageInfo<ProductCategory> pi=new PageInfo<ProductCategory>(list);
		
		return pi;
	}

	public int findcount(String name) throws SQLException {
		// TODO Auto-generated method stub
		return pcm.findcount(name);
	}

	public int findCountById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return pcm.findCountById(id);
	}

	public long findMaxId(Integer pid) throws SQLException {
		// TODO Auto-generated method stub
		return pcm.findMaxId(pid);
	}

	public List<ProductCategory> findProductCategorys() throws SQLException {
		// TODO Auto-generated method stub
		return pcm.findProductCategorys();
	}


}
