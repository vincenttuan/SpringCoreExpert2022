package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Paper;
import com.spring.core.session02.beans.PaperRedB3;

public class PaperTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Paper paper = ctx.getBean("paper", Paper.class);
		System.out.println(paper); // 資料已注入
		
		Paper paper2 = ctx.getBean("paper2", Paper.class);
		System.out.println(paper2); // 資料已注入
		
		PaperRedB3 paper3 = ctx.getBean("paper3", PaperRedB3.class);
		System.out.println(paper3); // 資料已注入
		
		Paper paper4 = ctx.getBean("paper4", Paper.class);
		System.out.println(paper4); // 資料已注入
		
	}
}
