package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.Car;
import com.spring.core.session03.beans.DBConn;

public class BeanFactoryTest {
	
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car1 = ctx.getBean("carFactory", Car.class);
		Car car2 = ctx.getBean("carFactory", Car.class);
		System.out.println(car1);
		System.out.println(car2);
	}
}
