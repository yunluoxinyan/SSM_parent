package com.mabiao.mybatis;


import com.mabiao.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author created by mabiao on 2018/8/3
 */
public class Test {
	public static void main(String[] args) {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			User user = sqlSession.selectOne("findById",1);
			System.out.println(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
