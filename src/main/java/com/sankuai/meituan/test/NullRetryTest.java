package com.sankuai.meituan.test;

public class NullRetryTest {

	public static void main(String[] args) throws Exception {
		NullRetryInterceptor in = new NullRetryInterceptor();
		in.parse(NullRetryAnnotated.class);
	}

}
