package me.renhai.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
   Given an array of integers, find two numbers such that they add up to a specific target number.
   The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
   You may assume that each input would have exactly one solution.
   Input: numbers={2, 7, 11, 15}, target=9
   Output: index1=1, index2=2
 * @author andy
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int[] res = new TwoSum().twoSum(nums, 3);
		for (int i : res) {
			System.out.print(i + "\t");
		}
	}
	
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i + 1};
			}
			map.put(nums[i], i + 1);
		}
    	throw new IllegalArgumentException("no answer");
    }

}
