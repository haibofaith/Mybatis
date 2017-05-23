package com.bean;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource = "conf.xml";
		//加载 mybatis 的配置文件(它也加载关联的映射文件)
		Reader reader = Resources.getResourceAsReader(resource);
		//构建 sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中 sql 的 sqlSession 
		SqlSession session = sessionFactory.openSession(true);
		
		String statement = "com.map.userMapper.selectUser";
		User user = session.selectOne(statement, 10);
		System.out.println(user.getName());
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		userMapper.addUser(new User("bobo",45));
//		session.close();
	}

}
