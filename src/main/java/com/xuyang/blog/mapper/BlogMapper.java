package com.xuyang.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.xuyang.blog.entity.Blog;

// Application.java中有自动扫描mapper目录，省去@mapper
// @Mapper
public interface BlogMapper {
	
	@Select("select * from blog where id = #{id} ")
	@Results({
        @Result(property = "htmlContent", column = "html_content")
    })
	Blog getOne(Long id);
	
	@Select("select * from blog")
	@Results({
		@Result(property = "htmlContent", column = "html_content")
    })
    List<Blog> getAll();
}
