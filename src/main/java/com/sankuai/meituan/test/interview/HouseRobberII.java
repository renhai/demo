package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * @author andy
 *
 */
public class HouseRobberII {

	public static void main(String[] args) {

	}
	
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int[] resFromFirst = new int[nums.length];
        int[] resFromSecond = new int[nums.length];
        resFromFirst[0] = nums[0]; 
        resFromFirst[1] = Math.max(nums[0], nums[1]);
        resFromSecond[0] = 0; 
        resFromSecond[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
        	resFromFirst[i] = Math.max(nums[i] + resFromFirst[i - 2], resFromFirst[i - 1]);
        	resFromSecond[i] = Math.max(nums[i] + resFromSecond[i - 2], resFromSecond[i - 1]);
		}
        return Math.max(resFromFirst[resFromFirst.length - 2], resFromSecond[resFromSecond.length - 1]);
    }

}
