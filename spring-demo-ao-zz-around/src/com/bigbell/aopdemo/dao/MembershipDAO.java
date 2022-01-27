package com.bigbell.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSilly() {
		
		System.out.println(getClass() + ": Doing Stuff: Adding a Membership Account");
		
		return true;
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": I'm going to sleep now!");
	}
}
