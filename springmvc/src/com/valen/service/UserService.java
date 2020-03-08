package com.valen.service;

import org.springframework.stereotype.Service;

import com.valen.domain.*;


@Service
public class UserService {
   
	public void createUser(User user){
		System.out.println("save user.");
	}

	public User getUserById(int userId) {
		User user = new User();
		user.setUserName("test");
		return user;
	}
	
}
