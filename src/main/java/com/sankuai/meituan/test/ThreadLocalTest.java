package com.sankuai.meituan.test;

public class ThreadLocalTest {
	
	private static final ThreadLocal<String> local = new ThreadLocal<String>();
	
	public String getName() {
		String name = local.get();
		if (name == null) {
			local.set(Thread.currentThread().getName());
		}
		return Thread.currentThread().getName();
	}

	public static void main(String[] args) {
		
	}

}
