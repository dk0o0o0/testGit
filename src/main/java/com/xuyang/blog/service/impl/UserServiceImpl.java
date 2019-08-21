package com.xuyang.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuyang.blog.entity.User;
import com.xuyang.blog.mapper.UserMapper;
import com.xuyang.blog.repository.UserRepository;
import com.xuyang.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	//JPA
	@Autowired
    private UserRepository userRepository;
	
	// mybatis
	@Autowired
    private UserMapper userMapper;
	
	@Override
    public List<User> getUserList() {
		// JPA
        //return userRepository.findAll();
		
		//mybatis
		return userMapper.getAll();
	}
	
	@Override
    public User findUserById(Long id) {
		// JPA
        //return userRepository.getOne(id);
		
		//mybatis
		return userMapper.getOne(id);
	}

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

}
