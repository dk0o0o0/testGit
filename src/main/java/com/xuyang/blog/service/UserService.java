package com.xuyang.blog.service;

import java.util.List;

import com.xuyang.blog.entity.User;

public interface UserService {

	public List<User> getUserList();
	
    public User findUserById(Long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);
}
