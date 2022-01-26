package com.spring.core.session04.proxy.sta;

public class Man implements Person {

	@Override
	public void work() {
		// 公用邏輯
		//System.out.println("出門戴口罩");
		
		// 業務邏輯
		System.out.println("上班工作");
		// ... 其他必要程序 ...
		// 假設發生例外 Exception
		throw new RuntimeException("口罩不見");
		
		// 公用邏輯
		//System.out.println("回家脱口罩");
	}

}
