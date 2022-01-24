package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Author;

public class AuthorTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author = ctx.getBean("author", Author.class);
		System.out.println(author); // 資料尚未注入
		author.setName("Vincent");  // 手動注入
		author.setSex('男');        // 手動注入
		author.setAge(25);          // 手動注入
		System.out.println(author);
		
		Author author2 = ctx.getBean("author2", Author.class); // 資料透過設定檔注入
		System.out.println(author2); // 資料已注入（透過方法）
		
		Author author3 = ctx.getBean("author3", Author.class); // 資料透過設定檔注入
		System.out.println(author3); // 資料已注入（透過建構子）
		
		Author author4 = ctx.getBean("author4", Author.class); // 資料透過設定檔注入
		System.out.println(author4); // 資料已注入（透過方法 p）
		
		Author author5 = ctx.getBean("author5", Author.class); // 資料透過設定檔注入
		System.out.println(author5); // 資料已注入（透過建構子 c）
	}
}
