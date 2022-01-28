package com.spring.core.session05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.session05.aop_lab.AOPConfig;
import com.spring.core.session05.aop_lab.Performance;
import com.spring.core.session05.aop_lab.Singer;

public class AOPLabTest {
	
	@Test
	public void test() {
		// Java 配置使用 AnnotationConfigApplicationContext
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
		Performance dancer = ctx.getBean("dancer", Performance.class);
		try {
			dancer.perform(); // 執行表演
		} catch (Exception e) {
			System.out.println(e); // 例外發生與處理
			// 轉換跑道
			// dancer 透過 introducter(經紀人) 轉換跑道
			// 例如：改行去唱歌
			System.out.println("舞者轉歌者");
			Singer singer = (Singer)dancer; // 舞者轉歌者
			singer.sing();
			
		}
	}
}
