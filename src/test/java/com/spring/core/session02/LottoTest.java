package com.spring.core.session02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.core.session02.beans.Lotto;

public class LottoTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Lotto lotto1 = ctx.getBean(Lotto.class);
		Lotto lotto2 = ctx.getBean(Lotto.class);
		System.out.println(lotto1);
		System.out.println(lotto2);
	}
}
