package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.session05.aop_lab.AOPConfig;
import com.spring.core.session05.aop_lab.Performance;

public class AOPLabTest {
	
	@Test
	public void test() {
		// Java 配置使用 AnnotationConfigApplicationContext
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		try {
			dancer.perform();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
