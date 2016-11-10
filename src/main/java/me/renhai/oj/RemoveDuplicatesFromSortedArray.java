package me.renhai.oj;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given input array nums = [1,1,2,2]
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
 * It doesn't matter what you leave beyond the new length.
 * @author andy
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,2,2,3};
		int len = new RemoveDuplicatesFromSortedArray().removeDuplicates2(nums);
		System.out.println("len = " + len);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
	}
	//11122 len = 5, i = 0
	//1122 len = 4, i = 0
	//122 len = 3, i = 0
	//122 len = 3, i = 1
	//12 len = 2, i = 1
    public int removeDuplicates(int[] nums) {
    	int len = nums.length;
        for (int i = 0; i < len - 1; ) {
			if (nums[i] == nums[i + 1]) {
				len --;
				System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
			} else {
				i ++;
			}
		}
        return len;
    }
    
    public int removeDuplicates2(int[] nums) {
    	int index = 1;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != nums[i - 1]) {
				nums[index ++] = nums[i];
			} 
		}
        return index;
    }

}
