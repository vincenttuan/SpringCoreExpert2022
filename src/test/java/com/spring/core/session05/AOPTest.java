package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session05.aop.CalcImpl;
import com.spring.core.session05.aop.Calc;

public class AOPTest {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		Calc calc = ctx.getBean("calcImpl", CalcImpl.class);
		System.out.println(calc.add(20,  10));
		System.out.println(calc.div(50,  5));
		System.out.println(calc.div(50,  0)); // 會拋出例外
	}
}
