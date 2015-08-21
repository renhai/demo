package com.sankuai.meituan.test.interview;

import java.util.Arrays;

public class MultiThreadCal extends Thread {
	public static int sum;
	
	private int[] arr;

	public MultiThreadCal(int[] arr) {
		this.arr = arr;
	}

	public int calSum(int[] arr) {
		int result = 0;
		if (arr != null) {
			for (int i : arr) {
				result += i;
			}
		}
		return result;
	}
	private static synchronized void inc(int number) {
		sum += number;
	}
	
	@Override
	public void run() {
		int result = calSum(arr);
		System.out.println(result);
		inc(result);
	}
	
	public static void main(String[] args) throws InterruptedException {
		int[] numbers = new int[] {1,2,3,4,5,6,7,8};
		
		int threadCount = 4;
		Thread[] threads = new Thread[threadCount];
		for (int i = 0; i < threadCount; i++) {
			int[] arr = Arrays.copyOfRange(numbers, 2 * i,  2 * (i + 1));
			Thread t1 = new MultiThreadCal(arr);
			threads[i] = t1;
			t1.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println(MultiThreadCal.sum);
	}
	
}
