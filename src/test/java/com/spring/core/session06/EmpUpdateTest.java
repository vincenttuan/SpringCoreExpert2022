package com.spring.core.session06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.core.session06.jdbc.dao.EmpDao;

public class EmpUpdateTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		
		// 修改-測試
		int rowcount = empDao.update(1, "Tom", 17);
		System.out.printf("修改: %d\n", rowcount);
		
	}
}
