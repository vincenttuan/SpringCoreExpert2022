package com.spring.core.session04.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

// 方法攔截器（cglib 使用）
public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("請輸入實聯簡訊資料");
		return proxy.invokeSuper(obj, args);
	}

	
	
}
