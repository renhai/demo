package com.sankuai.meituan.test;

/**
 * https://leetcode.com/problems/jump-game/
 * @author andy
 *
 */
public class JumpGame {

	public static void main(String[] args) {
		int[] nums1 = {2,3,1,1,4};
		int[] nums2 = {3,2,1,0,4};
		System.out.println(new JumpGame().canJump(nums1));
		System.out.println(new JumpGame().canJump(nums2));
	}
	
    public boolean canJump(int[] nums) {
    	int reachable = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (i > reachable) return false;
			reachable = Math.max(i + nums[i], reachable);
		}
    	return true;
    }
    
    public boolean canJump2(int[] nums) {
    	int reachable = 0;
    	for (int i = 0; i <= reachable; i++) {
			reachable = Math.max(i + nums[i], reachable);
			if (reachable >= nums.length - 1) 
				return true;
		}
    	return false;
    }

}
