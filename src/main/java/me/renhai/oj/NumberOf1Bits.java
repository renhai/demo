package me.renhai.oj;

public class NumberOf1Bits {

	public static void main(String[] args) {
		//  2147483648 (10000000000000000000000000000000)
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.parseInt("1111111111111111111111111111111", 2));
		int n = Integer.parseInt("1000000000000000000000000000000", 2);
		System.out.println(n);
		long  m = 2147483648L;
		System.out.println(new NumberOf1Bits().hammingWeight((int)m));
		
	}
	/**
	 * https://leetcode.com/problems/number-of-1-bits/
	 * @param n
	 * @return
	 */
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
        	result += n & 1;
        	n = n >>> 1;
        }
        return result;
    }
}
