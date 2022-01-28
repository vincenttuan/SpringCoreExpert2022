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
			dancer.perform();
		} catch (Exception e) {
			System.out.println(e);
			// 轉換跑道
			// dancer 透過 introducter(經紀人) 轉換跑道
			// 例如改行去唱歌或當主持人
			System.out.println("舞者轉歌者");
			Singer singer = (Singer)dancer; // 舞者轉歌者
			singer.sing();
			
		}
	}
}
