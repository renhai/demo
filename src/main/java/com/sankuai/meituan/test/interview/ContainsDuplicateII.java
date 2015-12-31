package com.sankuai.meituan.test.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * @author andy
 *
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {

	}
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
    		map.put(nums[i], i);
		}
    	return false;
    }

}
