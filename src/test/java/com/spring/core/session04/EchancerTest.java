package com.spring.core.session04;

import com.spring.core.session04.proxy.cglib.EchancerHello;
import com.spring.core.session04.proxy.cglib.Hello;

public class EchancerTest {
	public static void main(String[] args) {
		//Hello hello = new Hello();
		Hello hello = new EchancerHello();
		System.out.println(hello.sayHello("Vincent"));
	}
}
