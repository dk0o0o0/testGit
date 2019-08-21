package com.xuyang.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuyang.blog.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{
	
	@SuppressWarnings("unchecked")
	Blog save(Blog blog);
	
}
