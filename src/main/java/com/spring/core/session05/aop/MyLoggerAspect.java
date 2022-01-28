package com.spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面程式
@Component // 可被 Spring 管理的元件/物件
@Aspect // 切面
@Order(1) // 數字越小越先被執行（若不設定此配置，預設的數值是 int 的最大值）
		  // Order 的使用情境是在有多個切面程式在同一個橫切關注點要執行時
public class MyLoggerAspect {
	
	// 前置通知 Advice
	// Spring EL：execution(...)
	@Before(value = "execution(public Integer com.spring.core.session05.aop.CalcImpl.add(Integer, Integer))") // 切入點表達式
	public void beforeAdvice(JoinPoint joinPoint) { // JoinPoint 連接點
		String methodName = joinPoint.getSignature().getName(); // 取得連接點的方法簽章的名稱
		Object[] args = joinPoint.getArgs();
		System.out.printf("前置通知 - 方法名稱：%s 參數：%s\n", methodName, Arrays.toString(args));
	}
	
}
