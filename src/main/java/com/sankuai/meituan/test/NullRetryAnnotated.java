package com.sankuai.meituan.test;

import java.util.Random;

public class NullRetryAnnotated {
	
	private Random ran = new Random();
	
	@NullRetry
	public String getDataFromDB(String Key, String value) {
		System.out.println("loading data from database");
		if (ran.nextInt(5) == 2) {
			return "hello world";
		} 
		return null;
	}
}
