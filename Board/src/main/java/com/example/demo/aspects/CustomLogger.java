package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLogger {
	@Pointcut("execution(* com.example.demo.Services.QuestService.*(..))")
	public void getReq() {}
	
	@Pointcut("execution(* com.example.demo.Controllers.LoginController.signup(..))")
	public void sth() {}
	
	@Around("getReq()")
	public Object loggingGet(ProceedingJoinPoint pjp) {
		try{
			System.out.println("Fetching quests from database...");
			Object res = pjp.proceed();
			System.out.println("Fetched quests succesfully!");
			return res;
		}
		catch(Throwable e) {
			System.out.println("Fetching failed!");
			return "Error";
		}
	}
	
	
}
