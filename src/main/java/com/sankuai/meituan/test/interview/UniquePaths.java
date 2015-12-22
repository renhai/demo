package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/unique-paths/
 * @author andy
 *
 */
public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(new UniquePaths().uniquePaths(3, 7));
	}
	
	// 排列组合问题 https://leetcode.com/discuss/47829/math-solution-o-1-space
    public int uniquePaths2(int m, int n) {
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
    
    public int uniquePaths(int m, int n) {
    	if (m == 1 || n == 1) {
    		return 1;
    	}
    	
    	int[][] arr = new int[m][n];
    	for (int i = 0; i < m; i ++) {
    		arr[i][0] = 1;
    	}
    	for (int i = 0; i < n; i ++) {
    		arr[0][i] = 1;
    	}
    	
    	for (int i = 1; i < m; i ++) {
    		for (int j = 1; j < n; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
    	}
    	return arr[m - 1][n - 1];
    }

}
