package com.spring.core.session04.proxy.cglib;

// 子類別 / 增強（Echancer）的 Hello
public class EchancerHello extends Hello {

	@Override // 覆寫 / 攔截（Interceptor)
	public String sayHello(String str) {
		return super.sayHello(str) + " 請出示實聯簡訊資料";
	}
	
}
