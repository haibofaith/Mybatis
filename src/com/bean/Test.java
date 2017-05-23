package com.bean;

import java.io.IOException;
import java.io.Reader;

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
		SqlSession session = sessionFactory.openSession();
		//映射 sql 的标识字符串
		String statement = "com.bean.userMapper.getUser";
		//执行查询返回一个唯一 user 对象的 sql 
		User user = session.selectOne(statement, 1);
		System.out.println(user.getName()+user.getAge());
	}

}
