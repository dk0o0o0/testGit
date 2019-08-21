package com.xuyang.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xuyang.blog.entity.Blog;
import com.xuyang.blog.service.BlogService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/blog/list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<Blog> blogs = blogService.getBlogList();
		model.addAttribute("blogs", blogs);
		return "blog/list";
	}
	
	@RequestMapping("/toAdd")
    public String toAdd() {
        return "blog/blogAdd";
    }

    @RequestMapping("/add")
    public String add(Blog blog) {
    	blogService.save(blog);
        return "redirect:/blog/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
    	Blog blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/blogEdit";
    }

    @RequestMapping("/edit")
    public String edit(Blog blog) {
    	blogService.edit(blog);
        return "redirect:/blog/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
    	blogService.delete(id);
        return "redirect:/blog/list";
    }
    
    @RequestMapping("/testMD")
    public String testMD() {
        return "makedown/simple";
    }
    
    @RequestMapping("/testEditMD")
    public String testEditMD() {
        return "makedown/editMD";
    }
    
    @RequestMapping("/testIndex")
    public String testIndex() {
        return "index";
    }
    
}
