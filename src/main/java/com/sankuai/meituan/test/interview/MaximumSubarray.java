package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * @author andy
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int res = new MaximumSubarray().maxSubArray(nums);
		System.out.println(res);
	}
	
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
//        	if (sum < 0) {
//        		sum = nums[i];
//        	} else {
//        		sum += nums[i];
//        	}
        	sum = Math.max(sum + nums[i], nums[i]);
        	max = Math.max(max, sum);
		}
        return max;
    }

}
