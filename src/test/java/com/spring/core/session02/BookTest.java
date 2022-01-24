package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Author;
import com.spring.core.session02.beans.Book;

public class BookTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author2 = ctx.getBean("author2", Author.class);
		Book book = ctx.getBean("book", Book.class);
		System.out.println(book); // 資料尚未注入
		book.setName("Java");
		book.setPrice(500);
		book.setAuthor(author2);
		System.out.println(book);
		
		Book book2 = ctx.getBean("book2", Book.class);
		System.out.println(book2); // 資料已注入（方法）
		
		Book book3 = ctx.getBean("book3", Book.class);
		System.out.println(book3); // 資料已注入（建構子）
		
		Book book4 = ctx.getBean("book4", Book.class);
		System.out.println(book4); // 資料已注入（方法 p）
		
		Book book5 = ctx.getBean("book5", Book.class);
		System.out.println(book5); // 資料已注入（建構子 c）
	}
}
