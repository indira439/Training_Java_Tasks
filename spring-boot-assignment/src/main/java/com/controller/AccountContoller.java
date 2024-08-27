package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Account;
import com.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class AccountContoller {
	
	@Autowired
	AccountService acctSrvc;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	 public String showAccountServicesPage(Model mm,Account account)
	 {
		mm.addAttribute("acct", account);
		return "index";
	 }
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	 public String openAccountDetailsPage(Model mm,Account account)
	 {
		mm.addAttribute("acct", account);
		return "account";
	 }
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	 public String createAccount(Model mm,Account account)
	 {
		System.out.println(" inside create account " + account);
		String result = "";
		result =  acctSrvc.createAccount(account);
		System.out.println(" result " + result);
		mm.addAttribute("msg", result);
		mm.addAttribute("acct", account);
		return "status";
	 }
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	 public String depositAmount(Model mm,Account account)
	 {
		System.out.println(" inside deposit amount " + account);
		String result = "";
		result =  acctSrvc.depositAmount(account);
		System.out.println(" result " + result);
		mm.addAttribute("msg", result);
		mm.addAttribute("acct", account);
		return "deposit";
	 }
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	 public String withdrawAmount(Model mm,Account account)
	 {
		String result = "";
		result =  acctSrvc.withdrawAmount(account);
		System.out.println(" result " + result);
		mm.addAttribute("msg", result);
		mm.addAttribute("acct", account);
		return "withdraw";
	 }
	
	@RequestMapping(value = "/balance", method = RequestMethod.GET)
	 public String checkBalance(Model mm,Account account, HttpServletRequest req)
	 {
		String result = "";
		int acctNo = Integer.parseInt(req.getParameter("accountNo"));
		result =  acctSrvc.checkBalance(acctNo);
		System.out.println(" result " + result);
		mm.addAttribute("msg", result);
		mm.addAttribute("acct", account);
		return "balance";
	 }

}
