package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations-ii/
 * @author andy
 *
 */
public class PermutationsII {

	public static void main(String[] args) {

	}
	
	public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursive(nums, res, 0);
        return res;
	}
	
	private void recursive(int[] nums, List<List<Integer>> res, int start) {
		if (start == nums.length) {
			add(res, nums);
			return;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				swap(nums, i, start);
				recursive(nums, res, start + 1);
				swap(nums, i, start);
				set.add(nums[i]);
			}
		}
	}

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        add(res, nums);
        int index;
        while (true) {
            index = nums.length - 1;
			while (index > 0) {
				if (nums[index - 1] < nums[index]) {
					break;
				}
				index--;
			}
			if (index == 0) {
				break;
			}
			for (int i = nums.length - 1; i >= index; i--) {
				if (nums[i] > nums[index - 1]) {
					swap(nums, index - 1, i);
					break;
				}
			}
			reverse(nums, index, nums.length - 1);
			add(res, nums);
		}
		
		return res;       
    }
    
    private void add(List<List<Integer>> res, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        res.add(list);
    }
    
    private void reverse(int[] nums, int begin, int end) {
    	while (begin < end) {
    		swap(nums, begin, end);
    		begin ++;
    		end --;
    	}
    }
    
    private void swap(int[] nums, int m, int n) {
    	int tmp = nums[m];
    	nums[m] = nums[n];
    	nums[n] = tmp;
    }
}
