package com.spring.core.session04;

import org.springframework.cglib.proxy.Enhancer;

import com.spring.core.session04.proxy.cglib.EchancerHello;
import com.spring.core.session04.proxy.cglib.Hello;
import com.spring.core.session04.proxy.cglib.MyMethodInterceptor;

public class CglibTest {
	public static void main(String[] args) {
		//使用 cglib
		Enhancer enhancer = new Enhancer(); // 增強器
		enhancer.setSuperclass(Hello.class); // 要增強的對象
		enhancer.setCallback(new MyMethodInterceptor()); // 攔截目標方法
		Hello hello = (Hello)enhancer.create();
		System.out.println(hello.sayHello("Vincent"));
	}
}
