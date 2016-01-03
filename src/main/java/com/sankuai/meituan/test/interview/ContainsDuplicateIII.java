package com.sankuai.meituan.test.interview;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * @author andy
 *
 */
public class ContainsDuplicateIII {

	public static void main(String[] args) {
//		[0,2147483647]
//		1
//		2147483647
		int nums[] = {-1,2147483647};
		int k = 1;
		int t = 2147483647;
		System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, k, t));
		
	}
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if (nums == null || nums.length == 0 || k <= 0) return false;
    	TreeSet<Integer> set = new TreeSet<>();
    	for (int i = 0; i < nums.length; i++) {
    		Integer floor = set.floor(nums[i]);
    		Integer ceil = set.ceiling(nums[i]);
    		if ((floor != null && (long)nums[i] - (long)floor <= t) 
    				|| (ceil != null && (long)ceil - (long)nums[i] <= t)) {
    			return true;
    		}
			set.add(nums[i]);
			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
    	return false;
    }
    
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		if (j - i <= k && (long)nums[j] - (long)nums[i] <= t) {
        			return true;
        		}
        	}
		}
        return false;
    }

}
