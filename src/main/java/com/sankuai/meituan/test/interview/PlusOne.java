package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/plus-one/
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author andy
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = new int[] {9,9,9,9,8};
		int[] res = new PlusOne().plusOne(digits);
		for (int i : res) {
			System.out.print(i);
		}
	}
	
    public int[] plusOne(int[] digits) {
    	int[] res = new int[digits.length + 1];
    	int jinwei = 0;
    	for (int i = digits.length - 1; i >= 0; i--) {
    		if (i == digits.length -1) {
    			res[i + 1] = (jinwei + digits[i] + 1) % 10;
    			jinwei = (jinwei + digits[i] + 1) / 10;
    		} else {
    			res[i + 1] = (jinwei + digits[i]) % 10;
    			jinwei = (jinwei + digits[i]) / 10;
    		}
		}
    	if (jinwei > 0) {
			res[0] = jinwei;
		}
    	return res;
    }

}
