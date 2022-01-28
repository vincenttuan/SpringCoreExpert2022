package com.spring.core.session06;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SQLiteCreateDatabaseAndConnectionTest {
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		ComboPooledDataSource cp = ctx.getBean("dataSource", ComboPooledDataSource.class);
		try {
			System.out.println(cp.getConnection()); // 資料庫連線
		} catch (SQLException e) {
			System.out.println("資料庫建立連線失敗");
			e.printStackTrace();
			return;
		}
		System.out.println("資料庫建立連線成功");
	}
}

