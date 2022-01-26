package com.spring.core.session03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session03.beans.DBConn;
import com.spring.core.session03.mvc.controller.UserController;
import com.spring.core.session03.mvc.model.User;

public class MVCTest {
	
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		User user = ctx.getBean("user", User.class);
		System.out.println(user);
		
		// 將 user 模擬加入到資料庫
		// UserController -> UserService -> UserDao
		UserController userController = ctx.getBean("userController", UserController.class);
		userController.appendUser(user);
		
	}
}
