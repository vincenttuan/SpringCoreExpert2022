package com.spring.core.session01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringConfig;
import com.spring.core.session01.beans.Hello;

public class HelloTest {
	
	@Test
	public void test1() {
		// 傳統上建立 Hello 物件
		Hello hello1 = new Hello();
		System.out.println(hello1);
		
		// 利用 Spring 來取得所建立的 Hello 物件
		// xml 配置：applicationContext.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello2 = ctx.getBean(Hello.class);
		Hello hello3 = ctx.getBean("hello", Hello.class);
		System.out.println(hello2);
		System.out.println(hello3);
		
		// java 配置：SpringConfig.java
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(SpringConfig.class);
		Hello hello4 = ctx2.getBean(Hello.class);
		Hello hello5 = ctx2.getBean("hello", Hello.class);
		System.out.println(hello4);
		System.out.println(hello5);
	}

}
