package cn.dsscm.service;

import java.sql.SQLException;
import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.dsscm.pojo.News;

public interface NewsService {
	/**
	 * 删除新闻
	 * @param i
	 * @throws SQLException
	 */
	public int delete(Long i) throws SQLException;
	
	/**
	 * 更新新闻
	 * @param news
	 * @throws SQLException
	 */
	public int update(News news) throws SQLException;
	/**
	 * 保存新闻
	 * @param news
	 * @throws SQLException
	 */
	public int save(News news) throws SQLException;
	/**
	 * 获取本页要显示的新闻
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public PageInfo<News> getAllNews(Integer pageNum,Integer pageSize,String title) throws SQLException;
	/**
	 * 根据ID获取新闻
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public News findById(long id) throws SQLException;
	/**
	 * 获取新闻共有多少条记录
	 * @return
	 * @throws SQLException
	 */
	public long getNewsRowCount()  throws SQLException ;

}
