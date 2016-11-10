package me.renhai.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * @author andy
 *
 */
public class Permutations {

	public static void main(String[] args) {
		int[] nums = new int[]{0,1};
		List<List<Integer>> res = new Permutations().permute3(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
	
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        add(res, nums);
        
        int index;
        while (true) {
        	index = len - 1;
        	while (index > 0) {
        		if (nums[index - 1] < nums[index]) {
        			break;
        		}
        		index --;
        	}
        	if (index == 0) {
        		break;
        	} 
        	for (int i = len - 1; i >= index; i --) {
        		if (nums[i] > nums[index - 1]) {
        			swap(nums, i, index - 1);
        			break;
        		}
        	}
        	reverse(nums, index, len - 1);
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
	
	/**
	 * https://leetcode.com/discuss/17392/my-java-accepted-solution-without-additional-space
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursive(nums, res, 0);
        return res;
    }
    
    private void recursive(int[] nums, List<List<Integer>> res, int start) {
    	if (start == nums.length) {
    		List<Integer> list = new ArrayList<>();
    		for (int num : nums) {
				list.add(num);
			}
    		res.add(list);
    		return;
    	}
    	
    	for (int i = start; i < nums.length; i++) {
			swap(nums, i, start);
			recursive(nums, res, start + 1);
			swap(nums, i, start);
		}
    }
	
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        int count = 1;
        for (int i = 1; i <= len; i++) {
			count *= i;
		}
        for (int i = 0; i < count; i++) {
			nextPermutation(nums);
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < nums.length; j++) {
				list.add(nums[j]);
			}
			res.add(list);
		}
        
        return res;
    }
    
    private void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int index = nums.length - 1;
        while (index > 0) {
        	if (nums[index - 1] < nums[index]) {
        		break;
        	}
        	index --;
        }
        if (index == 0) {
        	reverse(nums, 0, nums.length - 1);
        } else {
        	for (int i = nums.length - 1; i >= index; i --) {
				if (nums[i] > nums[index - 1]) {
					swap(nums, index - 1, i);
					break;
				}
			}
        	reverse(nums, index, nums.length - 1);
        }
        
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
