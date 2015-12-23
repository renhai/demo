package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/next-permutation/
 * @author andy
 *
 */
public class NextPermutation {

	public static void main(String[] args) {

	}
	
    public void nextPermutation(int[] nums) {
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
