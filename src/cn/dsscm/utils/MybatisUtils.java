package cn.dsscm.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		try {
			// 读取配置文件
			InputStream inputStream = Resources
					.getResourceAsStream("mybatis-config.xml");
			// 根据配置文件构建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSession() {
		// 通过SqlSessionFactory创建SqlSession
		return sqlSessionFactory.openSession(true);//开启自动事务机制
	}
}
