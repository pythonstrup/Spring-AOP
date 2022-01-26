package com.bigbell.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of related advices for logging
	
	// let's start with an @Before advice

	@Pointcut("execution(* com.bigbell.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter/setter methods
	@Pointcut("execution(* com.bigbell.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.bigbell.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package .. exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApianalytics() {
		System.out.println("=======>>> performing API analytics");
	}
}
