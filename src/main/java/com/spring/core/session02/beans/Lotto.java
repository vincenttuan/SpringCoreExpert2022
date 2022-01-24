package com.spring.core.session02.beans;

import java.util.Random;

public class Lotto {
	private int number;
	
	public Lotto() {
		Random r = new Random();
		number = r.nextInt(100) + 1; // 1~100 
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Lotto [number=" + number + "]";
	}
}
