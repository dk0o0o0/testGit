package com.xuyang.blog.service;

import java.util.List;

import com.xuyang.blog.entity.Blog;

public interface BlogService {

	public List<Blog> getBlogList();
	
    public Blog findBlogById(Long id);

    public void save(Blog blog);

    public void edit(Blog blog);

    public void delete(long id);
}
