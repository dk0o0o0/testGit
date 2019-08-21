package com.xuyang.blog.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuyang.blog.entity.User;
import com.xuyang.blog.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

// 该注解返回字符串或json，不返回html/jsp
@RestController
@Slf4j
public class RestfullAPIController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${projectName:myproject}")
	private String projectName;
	
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    
    @RequestMapping("/getUser")
    public User getUser() {
    	User user=new User();
    	user.setUserName("小明");
    	user.setPassWord(projectName);
    	log.info("/getUser");
        return user;
    }
    
    @RequestMapping("/testDB")
    public List<User> testDB() {
    	Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
		String formattedDate = dateFormat.format(date);
		
		userRepository.save(new User("aa1", "aa@126.com", "aa123456",formattedDate));
		userRepository.save(new User("bb2", "bb@126.com", "bb123456",formattedDate));
		userRepository.save(new User("cc3", "cc@126.com", "cc123456",formattedDate));
		//userRepository.delete(userRepository.findByUserName("aa1"));
		
		return userRepository.findAll();
    }
    
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
