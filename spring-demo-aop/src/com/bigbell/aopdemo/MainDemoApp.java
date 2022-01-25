package com.bigbell.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bigbell.aopdemo.dao.AccountDAO;
import com.bigbell.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get the membership bean
		MembershipDAO membershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();
		
		// call the membership business method
		membershipDAO.addSilly();
		membershipDAO.goToSleep();
		
		// close the context
		context.close();
	}

}
