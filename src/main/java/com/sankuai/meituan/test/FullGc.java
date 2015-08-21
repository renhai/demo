package com.sankuai.meituan.test;

import java.util.ArrayList;
import java.util.Collection;

public class FullGc {

	private static final Collection<Object> leak = new ArrayList<>();
	private static volatile Object sink;

	public static void main(String[] args) {
		while (true) {
			try {
				leak.add(new byte[1024 * 1024]);
				sink = new byte[1024 * 1024];
			} catch (OutOfMemoryError e) {
				leak.clear();
			}
		}
	}

}
