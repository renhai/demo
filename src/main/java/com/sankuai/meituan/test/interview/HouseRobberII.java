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
        int[] res1 = new int[nums.length];
        int[] res2 = new int[nums.length - 1];
        res1[0] = nums[0]; res1[1] = Math.max(nums[0], nums[1]);
        res2[0] = nums[1]; res2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length; i++) {
        	res1[i] = Math.max(nums[i] + res1[i - 2], res1[i - 1]);
		}
        for (int i = 3; i < nums.length; i++) {
        	res2[i - 1] = Math.max(nums[i] + res2[i - 3], res2[i - 2]);
		}
        return Math.max(res1[res1.length - 2], res2[res2.length - 1]);
    }

}
