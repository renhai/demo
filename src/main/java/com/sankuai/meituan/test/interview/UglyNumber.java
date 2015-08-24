package com.sankuai.meituan.test.interview;

public class UglyNumber {
	/**
	 * https://leetcode.com/problems/ugly-number/
	 * @param num
	 * @return
	 */
    public boolean isUgly(int num) {
        int[] factors = new int[] {2,3,5};
        for (int fac : factors) {
			while (num % fac == 0 && num > 0) {
				num = num / fac;
			}
		}
        return num == 1;
    }
	
	public static void main(String[] args) {
		System.out.println(new UglyNumber().isUgly(0));
		System.out.println(new UglyNumber().isUgly(1));
		System.out.println(new UglyNumber().isUgly(2));
		System.out.println(new UglyNumber().isUgly(3));
		System.out.println(new UglyNumber().isUgly(6));
		System.out.println(new UglyNumber().isUgly(8));
		System.out.println(new UglyNumber().isUgly(9));
		System.out.println(new UglyNumber().isUgly(14));
		System.out.println(new UglyNumber().isUgly(100));
	}
}
