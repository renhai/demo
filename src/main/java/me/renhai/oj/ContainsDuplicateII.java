package me.renhai.oj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
    	Set<Integer> set = new HashSet<>();
    	for (int i = 0; i < nums.length; i++) {
    		if (set.contains(nums[i])) {
    			return true;
    		}
    		set.add(nums[i]);
    		if (i >= k) {
    			set.remove(nums[i - k]);
    		}
    	}
    	return false;
    }

}
