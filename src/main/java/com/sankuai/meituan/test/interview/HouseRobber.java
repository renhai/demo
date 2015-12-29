package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/house-robber/
 * @author andy
 *
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {7,5,8,3,2,9};
		int res = new HouseRobber().rob(nums);
		System.out.println(res);
	}
	
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        if (nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        }
        
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
        	res[i] = Math.max(nums[i] + res[i - 2], res[i - 1]);
		}
        return res[res.length - 1];
    }

}
