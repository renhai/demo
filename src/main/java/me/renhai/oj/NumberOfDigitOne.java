package me.renhai.oj;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 * @author andy
 *
 */
public class NumberOfDigitOne {

	public static void main(String[] args) {
		System.out.println(new NumberOfDigitOne().countDigitOne(Integer.MAX_VALUE));
	}
	
    public int countDigitOne(int n) {
    	int result = 0;
        for (int i = 1; i <= n; i++) {
			result += countOne(i);
		}
        return result;
    }
    
    private int countOne(int digit) {
    	int count = 0;
    	while (digit > 0) {
    		if (digit % 10 == 1)
    			count ++;
    		digit /= 10;
    	}
    	return count;
    }

}
