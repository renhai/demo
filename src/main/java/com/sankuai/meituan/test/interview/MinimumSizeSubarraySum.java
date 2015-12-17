package com.sankuai.meituan.test.interview;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {

	}
	
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < nums.length) {
        	sum += nums[end ++];
        	
        	while(sum >= s) {
        		minLen = Math.min(minLen, end - start);
        		sum -= nums[start ++];
        	}
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
