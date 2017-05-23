package com.bean;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
	@Insert("insert into users(name, age) values(#{name}, #{age})")
	int addUser(User user);
	@Delete("delete from users where id=#{id}")
	int deleteById(int id);
	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	int Update(User user);
	@Select("select * from users where id=#{id}")
	User getById(int id);
	@Select("select * from users")
	List<User> getAll();
}
