package com.spring.core.session04;

import com.spring.core.session04.proxy.sta.Man;
import com.spring.core.session04.proxy.sta.Person;
import com.spring.core.session04.proxy.sta.PersonProxy;
import com.spring.core.session04.proxy.sta.Woman;

public class ProxyStaticDemo {

	public static void main(String[] args) {
		// 不透過代理，直接執行
		/*
		Person man = new Man();
		Person woman = new Woman();
		man.work();
		woman.work();
		*/
		// 透過代理建構目標物件，由代理來執行
		Person man = new PersonProxy(new Man());
		Person woman = new PersonProxy(new Woman());
		man.work();
		woman.work();
	}

}
