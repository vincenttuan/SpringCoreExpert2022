package com.spring.core.session06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session06.jdbc.dao.EmpDao;
import com.spring.core.session06.jdbc.entity.Emp;

public class EmpCreateTest {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean(EmpDao.class);
		
		// 新增單筆-測試
		int rowcount = empDao.create("Jo", 21);
		System.out.printf("新增單筆: %d\n", rowcount);
		
		// 新增多筆-測試
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] {"Jean", 22});
		list.add(new Object[] {"Helen", 22});
		list.add(new Object[] {"Jack", 24});
		int[] rowcounts = empDao.batchCreate(list);
		System.out.printf("新增多筆: %s\n", Arrays.toString(rowcounts));
	}
}
