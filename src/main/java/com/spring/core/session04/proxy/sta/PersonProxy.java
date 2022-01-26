package com.spring.core.session04.proxy.sta;

// 靜態代理
// 代理物件就是代理執行任務
public class PersonProxy implements Person {
	
	// 代理對象
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	
	@Override
	public void work() {
		// before: 公用方法/邏輯
		System.out.println("出門戴口罩");
		
		// 代理執行代理對象的業務方法
		try {
			person.work();
		} catch (Exception e) {
			// excepton: 例外公用方法/邏輯
			System.out.println(e);
			System.out.println("去買口罩");
			System.out.println("將口罩戴回");
		}
		
		// end: 公用方法/邏輯
		System.out.println("回家脱口罩");
		
	}

}
