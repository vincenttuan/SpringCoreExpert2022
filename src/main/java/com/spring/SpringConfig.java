package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.beans.Hello;

@Configuration
public class SpringConfig {
	
	@Bean(name = "hello")
	public Hello getHello() {
		Hello hello = new Hello();
		return hello;
	}
	
}
