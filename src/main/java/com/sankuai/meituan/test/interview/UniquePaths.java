package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/unique-paths/
 * @author andy
 *
 */
public class UniquePaths {

	public static void main(String[] args) {

	}
	
	// 排列组合问题 https://leetcode.com/discuss/47829/math-solution-o-1-space
    public int uniquePaths(int m, int n) {
    	if (m == 1 || n == 1) {
    		return 1;
    	}
    	m --;
    	n --;
    	
    	if (m < n) {
	    	m = m + n;
	    	n = m - n;
	    	m = m - n;
    	}
    	long res = 1;
    	for (int i = m + 1,j = 1;  i <= m + n ; i++, j ++) {
			res *= i;
			res /= j;
		}
    	return (int) res;
    }

}
