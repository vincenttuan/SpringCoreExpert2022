package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Author;
import com.spring.core.session02.beans.Lotto;

public class AuthorTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Author author = ctx.getBean("author", Author.class);
		author.setName("Vincent");
		author.setSex('男');
		author.setAge(25);
		System.out.println(author);
		Author author2 = ctx.getBean("author2", Author.class);
		System.out.println(author2);
	}
}
