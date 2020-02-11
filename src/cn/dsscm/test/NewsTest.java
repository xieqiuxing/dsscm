package cn.dsscm.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.dsscm.dao.NewsMapper;
import cn.dsscm.pojo.News;
import cn.dsscm.utils.MybatisUtils;

public class NewsTest {
	@Test
	public void delete(){
		SqlSession sqlSession=MybatisUtils.getSession();
		try {
			int result=sqlSession.getMapper(NewsMapper.class).delete((long) 703);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void update(){
		SqlSession sqlSession=MybatisUtils.getSession();
		News news=new News();
		news.setId((long) 702);
		news.setTitle("9999");
		
		try {
			int result=sqlSession.getMapper(NewsMapper.class).update(news);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	@Test
	public void save(){
		SqlSession sqlSession=MybatisUtils.getSession();
		News news=new News();
		news.setContent("8888888888888888888888888");
		news.setTitle("888888888888888888");
		news.setCreatedBy((long) 9);
		try {
			int result=sqlSession.getMapper(NewsMapper.class).save(news);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	@Test
	public void selectAll(){
		SqlSession sqlSession=MybatisUtils.getSession();
		try {
			List<News> list=sqlSession.getMapper(NewsMapper.class).getAllNews();
			for (News news : list) {
				System.out.println(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	@Test
	public void findById(){
		SqlSession sqlSession=MybatisUtils.getSession();
		try {
			News news=sqlSession.getMapper(NewsMapper.class).findById(702);
			System.out.println(news);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	@Test
	public void findCount(){
		SqlSession sqlSession=MybatisUtils.getSession();
		try {
			int rows=(int) sqlSession.getMapper(NewsMapper.class).getNewsRowCount();
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	@SuppressWarnings("deprecation")
	@Test
	public void getday(){
		Date time=new Date(); 
		System.out.println(time.getYear()+"年"+time.getMonth()+"月"+time.getDate()+"日");
		System.out.println(time.getHours()+":"+time.getMinutes()+":"+time.getSeconds());
		System.out.println(time.getDay());
	}
}
