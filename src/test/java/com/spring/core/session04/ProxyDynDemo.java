package com.spring.core.session04;

import com.spring.core.session04.proxy.dyn.Calc;
import com.spring.core.session04.proxy.dyn.CalcImpl;
import com.spring.core.session04.proxy.dyn.ProxyDynUtil;
import com.spring.core.session04.proxy.sta.Man;
import com.spring.core.session04.proxy.sta.Person;

public class ProxyDynDemo {

	public static void main(String[] args) {
		Person man = (Person)new ProxyDynUtil(new Man()).getProxy();
		man.work();
		System.out.println();
		Calc calc = (Calc)new ProxyDynUtil(new CalcImpl()).getProxy();
		System.out.println(calc.add(10, 20));
		System.out.println(calc.div(10, 5));
		System.out.println(calc.div(10, 0));
	}

}
