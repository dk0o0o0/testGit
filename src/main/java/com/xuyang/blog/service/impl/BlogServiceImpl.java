package com.xuyang.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuyang.blog.entity.Blog;
import com.xuyang.blog.mapper.BlogMapper;
import com.xuyang.blog.repository.BlogRepository;
import com.xuyang.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	//JPA
	@Autowired
    private BlogRepository blogRepository;
	
	// mybatis
    @Autowired

    private BlogMapper blogMapper;

	@Override
    public List<Blog> getBlogList() {
		return blogMapper.getAll();
	}

	@Override
    public Blog findBlogById(Long id) {
		return blogMapper.getOne(id);
	}

    @Override
    public void save(Blog blog) {
    	blogRepository.save(blog);
    }

    @Override
    public void edit(Blog blog) {
    	blogRepository.save(blog);
    }

    @Override
    public void delete(long id) {
    	blogRepository.deleteById(id);
    }

}
