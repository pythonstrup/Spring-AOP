package com.bigbell.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	@Pointcut("execution(* com.bigbell.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter/setter methods
	@Pointcut("execution(* com.bigbell.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.bigbell.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create point: include package .. exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
