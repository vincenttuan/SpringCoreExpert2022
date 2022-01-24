package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Paper;

public class PaperTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Paper paper = ctx.getBean("paper", Paper.class);
		System.out.println(paper); // 資料已注入
		
	}
}
