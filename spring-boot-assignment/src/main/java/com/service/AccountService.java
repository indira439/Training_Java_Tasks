package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.repository.AccountRepository;


@Service
public class AccountService {
	
	@Autowired
	public AccountRepository accountRepo;
	
	public String createAccount(Account acct)
	{
		Optional<Account> result = accountRepo.findById(acct.getAccountNo());
		if(result.isPresent())
		{
			return "Account number already exists. Please try with new account number.";
		}
		else
		{
			if(acct.getAccountBalance() > 1000)
			{
				accountRepo.save(acct);
				return "Congrats! Account created successfully"; 
			}
			else
			{
				return "Account was not created. Opening balance should be greater than 1000 rs.";
			}
 
		}
	}
	
	public String depositAmount(Account acct)
	{
		Optional<Account> result = accountRepo.findById(acct.getAccountNo());
		if(result.isPresent())
		{
			if(acct.getAccountBalance() >= 50000)
			{
				return "Pan card is required for deposit's more than 50,000. Please provide your PAN and try again";
			}
			else
			{
				Account account = result.get();
				account.setAccountBalance(Float.sum(account.getAccountBalance(), acct.getAccountBalance()));
			    accountRepo.saveAndFlush(account);
				return "Rs." + acct.getAccountBalance() + "/ successfully credited to your account.";
			}
		}
		else
			return "Account not found. Please check entered account number correctly";
				
	}
	
	public String withdrawAmount(Account acct)
	{
		Optional<Account> result = accountRepo.findById(acct.getAccountNo());
		if(result.isPresent())
		{
			Account account = result.get();
			float balance = account.getAccountBalance() - acct.getAccountBalance();
			if(balance >= 10000)
			{
				account.setAccountBalance(balance);
				return "Rs. " + acct.getAccountBalance() + "/ withdrawn from your account ";
			}
			return "Can't withdraw amount. A mimimum of 10,000rs should be maintained in your account.";
		}
		else
			return "Account not found. Please check entered account number correctly";
	}
	
	public String checkBalance(int actNo)
	{
		Optional<Account> result = accountRepo.findById(actNo);
		if(result.isPresent())
		{
			
			return "Your current account balance is " + result.get().getAccountBalance();
		}
		else
			return "Account not found. Please check entered account number correctly";
	}

}
