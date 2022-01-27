package com.bigbell.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bigbell.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.bigbell.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @After (finally) on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			
			// log the exception
			myLogger.warning(e.getMessage());
			
//			// give user a custom message
//			result = "Major accident! But no worries mate!"
//					+ " your private AOP is on the way";
			
			// rethrow exception
			throw e;
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====>>>> Duration: " + duration/1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.bigbell.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @After (finally) on method: " + method);
				
	}
	
	@AfterThrowing(
			pointcut="execution(* com.bigbell.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint joinPoint, Throwable exc) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n======> The exception is: " + exc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.bigbell.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
					JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n======> result is: " + result);
		
		// let's post-process the data ... let's modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n======> result is: " + result);
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for (Account tempAccount: result) {
			
			// get uppercase version of name
			String upperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(upperName);
		}
		
		
	}

	
	@Before("com.bigbell.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync(JoinPoint joinpoint) {
		myLogger.info("\n=======>>> Logging to Cloud in async fashion");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinpoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = joinpoint.getArgs();
		
		// loop thru args
		for (Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account account = (Account) tempArg;
				
				myLogger.info("account name: " + account.getName());
				myLogger.info("account level: " + account.getLevel());
			}
		}
	}
	
	
}













