package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author andy
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(44));
		System.out.println(new ClimbingStairs().climbStairs2(44));
	}
	
    public int climbStairs(int n) {
        if (n == 1) {
			return 1;
		}
        if (n == 2) {
			return 2;
		}
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    
    public int climbStairs2(int n) {
        if (n == 0 || n == 1 || n == 2) {
			return n;
		}
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < res.length; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
        return res[n - 1];
    }

}
