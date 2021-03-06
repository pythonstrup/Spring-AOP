package com.bigbell.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {
	
	@Before("com.bigbell.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApianalytics() {
		System.out.println("\n=======>>> performing API analytics");
	}
}
