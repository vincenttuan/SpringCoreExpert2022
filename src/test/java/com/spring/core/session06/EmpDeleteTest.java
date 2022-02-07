package com.spring.core.session06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.core.session06.jdbc.dao.EmpDao;

public class EmpDeleteTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		
		// 刪除-測試
		int rowcount = empDao.delete(2); // 刪除 eid = 2 的資料
		System.out.printf("刪除: %d\n", rowcount);
		
	}
}
