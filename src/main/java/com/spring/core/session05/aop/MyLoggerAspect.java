package com.spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面程式
@Component // 可被 Spring 管理的元件/物件
@Aspect // 切面
@Order(1) // 數字越小越先被執行（若不設定此配置，預設的數值是 int 的最大值）
		  // Order 的使用情境是在有多個切面程式在同一個橫切關注點要執行時
public class MyLoggerAspect {
	// 建立一個切入點的方法
	@Pointcut(value = "execution(* com.spring.core.session05.aop.CalcImpl.*(..))")
	public void pt() {}
	@Pointcut(value = "execution(* com.spring.core.session05.aop.CalcImpl.div(..))")
	public void pt2() {}
	
	/*
	// 前置通知 Advice
	// Spring EL：execution(...)
	//@Before(value = "execution(public Integer com.spring.core.session05.aop.CalcImpl.add(Integer, Integer))") // 切入點表達式
	//@Before(value = "execution(* com.spring.core.session05.aop.CalcImpl.add(Integer, Integer))") // 忽略 Returning and type
	//@Before(value = "execution(* com.spring.core.session05.aop.CalcImpl.add(..))") // 續上 + 忽略 any method-args
	//@Before(value = "execution(* com.spring.core.session05.aop.CalcImpl.*(..))") // 續上 + 忽略 method-name
	//@Before(value = "execution(* com.spring.core.session05.aop.*.*(..))") // 續上 + 忽略 class-name
	//@Before(value = "execution(* *(..))") // 全部都攔截
	//@Before(value = "pt() && !pt2()") // 切入表達式支援 &&、||、!
	@Before(value = "pt()") // 切入表達式支援
	public void beforeAdvice(JoinPoint joinPoint) { // JoinPoint 連接點
		String methodName = joinPoint.getSignature().getName(); // 取得連接點的方法簽章的名稱
		Object[] args = joinPoint.getArgs();
		System.out.printf("前置通知 - 方法名稱：%s 參數：%s\n", methodName, Arrays.toString(args));
	}
	
	// 後置通知 Advice（無論是否有拋出例外都會執行，所以後製通知在Spring-AOP機制上會自動放在 finally 區段中）
	@After(value = "pt()")
	public void afterAdvice() {
		System.out.println("後置通知");
	}
	
	// 異常通知（可以設定 throwing 異常通知變數）
	@AfterThrowing(value = "pt()", throwing = "ex")
	public void afterThrowingAdvice(Exception ex) { // 方法參數 ex 必須與 throwing = "ex" 內容名稱設定相同
		System.out.printf("異常通知 - ex: %s\n", ex);
	}
	
	// 返回通知（可以設定 returning 來接收方法的返回值）
	// 若有異常發生，則返回通知不會執行
	@AfterReturning(value = "pt()", returning = "result")
	public void afterReturningAdvice(Object result) { // 返回值的型態是 Object
		System.out.printf("返回通知 - result: %s\n", result);
	}
	*/
	
	// 環繞通知
	// 注意：要進行環繞通知測試前，請先將其他 XX 通知關閉
	@Around(value = "pt()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
		Object result = null;
		try {
			// 1. 前置通知
			String methodName = joinPoint.getSignature().getName(); // 取得連接點的方法簽章的名稱
			Object[] args = joinPoint.getArgs();
			System.out.printf("環繞通知：前置通知 - 方法名稱：%s 參數：%s\n", methodName, Arrays.toString(args));
			
			// 執行業務邏輯方法（重要！一定要加入）
			result = joinPoint.proceed();
			
			// 2. 返回通知
			System.out.printf("環繞通知 - 返回通知 結果：%s\n", result);
			
		} catch (Throwable ex) {
			// 3. 異常通知
			System.out.printf("環繞通知 - 異常通知：%s\n", ex);
			
		} finally {
			// 4. 後置通知
			System.out.println("環繞通知 - 後置通知");
		}
		
		return result;
	}
	
	
	
}
