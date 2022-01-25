package com.bigbell.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of related advices for logging
	
	// let's start with an @Before advice
	
//	@Before("execution(public void com.bigbell.aopdemo.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice() {
//		
//		System.out.println("\n=======>>> Executing @Before advice on addAccount()");
//	}
	
	//@Before("execution(public void add*())")
	
//	@Before("execution(void add*())")
//	@Before("execution(* add*())")
	
	
//	@Before("execution(* add*(com.bigbell.aopdemo.Account, ..))")
//	@Before("execution(* add*(..))")
	
	// *[all return type] com.bigbell.aopdemo.dao[package].*[all class].*[all method](..)[all params]
	@Before("execution(* com.bigbell.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======>>> Executing @Before advice on addAccount()");
	}
}
