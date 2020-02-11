package cn.dsscm.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.dsscm.dao.NewsMapper;
import cn.dsscm.pojo.News;
import cn.dsscm.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
	@Resource
	private NewsMapper newsMapper;
	public int delete(Long i) throws SQLException {
		// TODO Auto-generated method stub
		return newsMapper.delete(i);
	}

	public int update(News news) throws SQLException {
		// TODO Auto-generated method stub
		return newsMapper.update(news);
	}

	public int save(News news) throws SQLException {
		// TODO Auto-generated method stub
		return newsMapper.save(news);
	}

	public PageInfo<News> getAllNews(Integer pageNum,Integer pageSize,String title) throws SQLException {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<News> list=newsMapper.getAllNews(title);
		PageInfo<News> pn=new PageInfo<News>(list);
		return pn;
	}

	public News findById(long id) throws SQLException {
		// TODO Auto-generated method stub
		return newsMapper.findById(id);
	}

	public long getNewsRowCount() throws SQLException {
		// TODO Auto-generated method stub
		return newsMapper.getNewsRowCount();
	}

}
