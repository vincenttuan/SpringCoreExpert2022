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
		Author author = ctx.getBean("author", Author.class);
		Book book = ctx.getBean("book", Book.class);
		System.out.println(book); // 資料尚未注入
		book.setName("Java");
		book.setPrice(500);
		book.setAuthor(author);
		System.out.println(book);
		
		
	}
}
