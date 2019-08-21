package com.xuyang.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.xuyang.blog.entity.User;

// Application.java中有自动扫描mapper目录，省去@mapper
// @Mapper
public interface UserMapper {
	
	@Select("select * from user where id = #{id} ")
	@Results({
        @Result(property = "userName",  column = "user_name"),
        @Result(property = "passWord", column = "pass_word"),
        @Result(property = "regTime", column = "reg_time")
    })
	User getOne(Long id);
	
	@Select("select * from user")
	@Results({
        @Result(property = "userName",  column = "user_name"),
        @Result(property = "passWord", column = "pass_word"),
        @Result(property = "regTime", column = "reg_time")
    })
    List<User> getAll();
}
