package com.spring.core.session05.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introducter { // 介紹人/經紀人
	
	// 將 Performance 及其子類別轉換為 Singer（預設實作：BackSinger）
	@DeclareParents(value = "com.spring.core.session05.aop_lab.Performance+",
					defaultImpl = BackSinger.class)
	public Singer singer;
	
}
