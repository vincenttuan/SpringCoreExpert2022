package com.spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 觀眾：切面程式
public class Audience {
	@Pointcut(value = "execution(* com.spring.core.session05.aop_lab.Performance.perform(..))")
	public void pt() {}
	
	@Before(value = "pt()")
	public void slienceCellPhone() {
		System.out.println("關掉手機");
	}
	
	@Before(value = "pt()")
	public void takeSeats() {
		System.out.println("找到座位");
	}
	
}
