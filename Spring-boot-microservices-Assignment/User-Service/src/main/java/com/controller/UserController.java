package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping(value = "getUser/{id}")
	public User getUserById(@PathVariable("id") int userId)
	{
		System.out.println("call getuserById method");

		return userservice.getUserById(userId);
	}
	
	@GetMapping(value = "getUserName/{id}")
	public String getUserNameById(@PathVariable("id") int userId)
	{
		System.out.println("call getuserNameById method");

		return userservice.getUserNameById(userId);
	}
	
	@PostMapping(value = "saveUser")
	public String saveUser(@RequestBody User user)
	{
		return userservice.saveUser(user);
	}
	
	@GetMapping(value = "allUsers")
	public List<User> getAllUsers()
	{
		return userservice.getAllUsers();
	}

}
