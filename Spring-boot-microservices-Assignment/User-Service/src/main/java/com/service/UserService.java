package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findById(userId);
		System.out.println("inside getuserById method");
		if(user.isPresent())
		{
			System.out.println("call user.get");
			return user.get();
		}
		else
		{
			return null;
		}
	}

	public String saveUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> result = userRepo.findById(user.getId());
		if(result.isPresent())
		{
			return "User already exists";
		}
		else
		{
			userRepo.save(user);
			return "User details saved successfully";
		}
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public String getUserNameById(int userId) {
		// TODO Auto-generated method stub
		Optional<User> result = userRepo.findById(userId);
		System.out.println("inside getuserById method");
		if(result.isPresent())
		{
			User user = result.get();
			return user.getUsername();
		}
		else
		{
			return "User doesn't exist";
		}
	}

}
