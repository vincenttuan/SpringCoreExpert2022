package com.spring.core.session06;

import java.util.Optional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.jdbc.dao.EmpDao;

public class EmpTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		System.out.println(empDao.query());
		System.out.println(empDao.queryEmps());
		
	}
}
