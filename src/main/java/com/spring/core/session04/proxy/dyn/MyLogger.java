package com.spring.core.session04.proxy.dyn;

import java.util.Arrays;

// Aspect 切面程式（公用邏輯）
public class MyLogger {
	// Before: 前置通知
	public static void before(Class cls, String methodName, Object[] args) {
		System.out.printf("前置通知：%s %s %s\n", cls, methodName, Arrays.toString(args));
	}
	// Exception: 例外異常通知
	public static void throwing(Class cls, String errorMessage) {
		System.out.printf("異常通知：%s %s\n", cls, errorMessage);
	}
	// End: 後置通知
	public static void end(Class cls, String methodName, Object result) {
		System.out.printf("後置通知：%s %s %s\n", cls, methodName, result);
	}
}
