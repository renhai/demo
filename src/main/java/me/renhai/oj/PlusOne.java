package me.renhai.oj;

/**
 * https://leetcode.com/problems/plus-one/
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * @author andy
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = new int[] {9,9,8,9,9};
		int[] res = new PlusOne().plusOne2(digits);
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
    	if (res[0] == 0) {
    		int[] dest = new int[res.length - 1]; 
			System.arraycopy(res, 1, dest, 0, dest.length);
			return dest;
		}
    	return res;
    }
    
	public int[] plusOne2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i] ++;
				break;
			} else {
				digits[i] = 0;
			}
		}
		if (digits[0] == 0) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			return res;
		}
		return digits;
	}

}
