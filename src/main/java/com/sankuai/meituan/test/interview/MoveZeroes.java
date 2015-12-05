package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/move-zeroes/
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
 * @author andy
 *
 */
public class MoveZeroes {

	public static void main(String[] args) {
//		int[] arr = new int[] {0, 1, 0, 3, 12};
		int[] arr = new int[] {1,0,0,2};
		new MoveZeroes().moveZeroes2(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
    public void moveZeroes(int[] nums) {
    	int lastIndex = nums.length - 1;
        for (int i = 0; i <= lastIndex;) {
			if (nums[i] == 0) {
				System.arraycopy(nums, i + 1, nums, i, lastIndex - i);
				nums[lastIndex --] = 0;
			} else {
				i ++;
			}
		}
    }
    
    public void moveZeroes2(int[] nums) {
    	int index = 0;
        for (int num : nums) {
        	if (num != 0) {
        		nums[index ++] = num;
        	}
		}
        
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

}
