package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.repository.LoginRepo;

@Service
public class LoginService {
	
	@Autowired
	LoginRepo lRepo;
	

	public int addUser(Login login) {
		// TODO Auto-generated method stub
		return lRepo.saveUser(login);
	}


	public int validateUser(String emailId) {
		// TODO Auto-generated method stub
		return lRepo.getUserByEmailId(emailId);
	}

}
