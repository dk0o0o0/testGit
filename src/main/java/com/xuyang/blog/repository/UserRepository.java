package com.xuyang.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuyang.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@SuppressWarnings("unchecked")
	User save(User user);
	
}
