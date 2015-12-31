package com.sankuai.meituan.test.interview;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 * @author andy
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
//		int[] nums = {-4, -1, 1, 2};
//		int[] nums = {0, 1, 1, 1};
		int[] nums = {-3, 0, 1, 2};
		int target = 1;
		int res = new ThreeSumClosest().threeSumClosest(nums, target);
		System.out.println(res);
	}
	
    public int threeSumClosest(int[] nums, int target) {
    	if (nums == null || nums.length < 3) return 0;
    	Arrays.sort(nums);
    	int min = Integer.MAX_VALUE;
    	int close = 0;
    	for (int i = 0; i < nums.length - 1; i++) {
    		int low = i + 1;
    		int hi = nums.length - 1;
    		int sum = nums[low] + nums[hi] + nums[i];
    		while (low < hi) {
    			sum = nums[low] + nums[hi] + nums[i];
    			if (Math.abs(target - sum) < min) {
    				min = Math.abs(target - sum);
    				close = sum;
    			}
    			if (sum == target) {
    				return target;
    			} else if (sum > target) {
    				while (low < hi && nums[hi] == nums[hi - 1]) {
    					hi --;
    				}
    				hi --;
    			} else {
    				while (low < hi && nums[low] == nums[low + 1]) {
    					low ++;
    				}
    				low ++;
    			}
    		}
    		
		}
    	return close;
    }

}
