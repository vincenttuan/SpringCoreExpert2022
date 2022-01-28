package com.spring.core.session05.aop_lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Spring 的配置有二種：XML 配置與 Java 配置
// 本範例使用 Java 配置來取代 aop-config.xml
@Configuration // 此為配置檔
@EnableAspectJAutoProxy // 自動代理配置
@ComponentScan // 啟用元件掃描
public class AOPConfig {
	
	@Bean(name = "dancer") // 若 name 的名稱與方法名相同，可以忽略不寫
	public Performance dancer() {
		Dancer dancer = new Dancer();
		return dancer;
	}
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
}
