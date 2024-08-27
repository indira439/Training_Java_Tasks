package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	Login login;
	@Autowired
	LoginService loginSrvc;
	
	@RequestMapping(value = "SignIn",method = RequestMethod.POST)
	public ModelAndView signInMethod(HttpServletRequest req)
	{	    
	    
	    ModelAndView mv = new ModelAndView();
	    System.out.println(loginSrvc.validateUser(req.getParameter("emailId")));

		if(loginSrvc.validateUser(req.getParameter("emailId")) > 0)
		{
	    	if(req.getParameter("userType").equals("Admin"))
	    		mv.setViewName("Admin.jsp");
	    	else
	    		mv.setViewName("Customer.jsp");
		}
    	else
    		mv.setViewName("InvalidUser.jsp");
		return mv;
		
	}
	
	@RequestMapping(value = "SignUp",method = RequestMethod.POST)
	public ModelAndView signUpMethod(HttpServletRequest req)
	{
		login.setEmailId(req.getParameter("emailId"));
	    login.setPassword(req.getParameter("password"));
	    login.setUserType(req.getParameter("userType"));
	    
	    System.err.println(req.getParameter("userType"));

	    
	    ModelAndView mv = new ModelAndView();
	    if(loginSrvc.addUser(login) > 0)
	    {
	    	mv.setViewName("Success.jsp");;
	    }
	    else
	    {
	    	mv.setViewName("Failed.jsp");
	    }
	    
		return mv;
		
	}
	
	

}
