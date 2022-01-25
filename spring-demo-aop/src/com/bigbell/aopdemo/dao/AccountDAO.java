package com.bigbell.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.bigbell.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": Doing my DB work: Adding an Account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
