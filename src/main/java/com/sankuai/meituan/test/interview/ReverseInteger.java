package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author renhai
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
//		int x = 1534236469;
		int x = 2147483647;
		System.out.println(new ReverseInteger().reverse(x));

	}
	
    public int reverse(int x) {
        long result = 0L;
        while (x != 0) {
        	result = result * 10 + (x % 10);
        	x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
        return (int)result;
    }

}
