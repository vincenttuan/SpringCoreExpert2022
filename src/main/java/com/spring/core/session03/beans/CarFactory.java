package com.spring.core.session03.beans;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory implements FactoryBean<Car> {
	
	@Override
	public Car getObject() throws Exception {
		Random random = new Random();
		int price = random.nextInt(300_0000);		
		return new Car("BMW", price);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
