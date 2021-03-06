package com.bigbell.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing(
			pointcut="execution(* com.bigbell.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="exc")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint joinPoint, Throwable exc) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n======> The exception is: " + exc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.bigbell.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
					JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n======> result is: " + result);
		
		// let's post-process the data ... let's modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n======> result is: " + result);
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
		System.out.println("\n=======>>> Logging to Cloud in async fashion");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinpoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = joinpoint.getArgs();
		
		// loop thru args
		for (Object tempArg: args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account account = (Account) tempArg;
				
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
	}
	
	
}













