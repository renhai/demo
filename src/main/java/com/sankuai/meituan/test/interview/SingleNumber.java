package com.sankuai.meituan.test.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	/**
	 * https://leetcode.com/problems/single-number/
	 * Given an array of integers, every element appears twice except for one. 
	 * Find that single one.
	 * N XOR N = 0
	 * N XOR 0 = N
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
    	int result = 0;
        for (int i : nums) {
			result ^= i;
		}
        return result;
    }
    
    /**
     * https://leetcode.com/problems/single-number-ii/
     * Given an array of integers, every element appears three times except for one.
     * Find that single one.
     * @param nums
     * @return
     */
    public int singleNumberII(int[] nums) {
    	Arrays.sort(nums);
    	int result = nums[0];
    	for (int i = 1; i < nums.length - 1; i++) {
    		int prev = nums[i - 1];
			int curr = nums[i];
			int next = nums[i + 1];
			if (curr != prev && curr != next) {
				result = curr;
				break;
			} else if (i == nums.length - 2 && curr != next) {
				result = next;
				break;
			}
		}
      	return result;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,1,2,77};
		int result = new SingleNumber().singleNumber(nums);
		System.out.println(result);
		
		int[] numsII = new int[] {1,2,1,2,1,2,7};
		int resultII = new SingleNumber().singleNumber(numsII);
		System.out.println(resultII);
	}

}
