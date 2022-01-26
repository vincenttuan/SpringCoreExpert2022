package com.spring.core.session04.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 動態代理
public class ProxyDynUtil {
	// 被代理對象
	private Object object;
	
	public ProxyDynUtil(Object object) {
		this.object = object;
	}
	
	// 取得代理對象
	public Object getProxy() {
		Object proxyObj = null;
		// 1. 類別載入器 ClassLoader
		ClassLoader loader = object.getClass().getClassLoader();
		// 2. 被代理對象所實作的介面 Class[]
		Class[] interfaces = object.getClass().getInterfaces();
		// 3. 處理代理的實現 InvocationHandler
		InvocationHandler invocationHandler = (Object proxy, Method method, Object[] args) -> {
			Object result = null;
			try {
				// Before: 前置通知
				//System.out.println("Before: 前置通知");
				MyLogger.before(object.getClass(), method.getName(), args);
				// 調用業務方法/邏輯
				result = method.invoke(object, args);
				return result;
			} catch (Exception e) {
				// Exception: 例外異常通知
				//System.out.println("Exception: 例外異常通知");
				MyLogger.throwing(object.getClass(), e.toString());
			} finally {
				// End: 後置通知
				//System.out.println("End: 後置通知");
				MyLogger.end(object.getClass(), method.getName(), result);
			}
			return result;
		};
		proxyObj = Proxy.newProxyInstance(loader, interfaces, invocationHandler);
		return proxyObj;
	}
}
