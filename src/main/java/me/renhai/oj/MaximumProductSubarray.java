package me.renhai.oj;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * @author andy
 *
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] nums = {2,3,-2,4,-3};
		System.out.println(new MaximumProductSubarray().maxProduct(nums));
	}
	
    public int maxProduct(int[] nums) {
    	if (nums == null || nums.length == 0) 
    		return 0;
    	int max = nums[0];
    	int min = nums[0];
    	int res = nums[0];
    	for (int i = 1; i < nums.length; i++) {
    		int maxCopy = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(maxCopy * nums[i], min * nums[i]), nums[i]);
			res = Math.max(max, res);
		}
    	return res;
    }

}
