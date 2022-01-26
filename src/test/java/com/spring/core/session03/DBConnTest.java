package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.DBConn;

public class DBConnTest {
	
	@Test
	public void test1() {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DBConn dbConn = ctx.getBean("dbconn", DBConn.class);
		dbConn.query();
		// 關閉 context
		//((ClassPathXmlApplicationContext)ctx).close();
		ctx.close();
		
	}
}
