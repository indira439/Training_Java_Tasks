package com.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
@Scope("Prototype")
public class Account {
	
	@Id
	private int accountNo;
	private String accountName;
	private float accountBalance;
	
	public int getAccountNo()
	{
		return accountNo;
	}
	
	public void setAccountNo(int accountId)
	{
		this.accountNo = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountName=" + accountName + ", accountBalance=" + accountBalance
				+ "]";
	}
	
}
