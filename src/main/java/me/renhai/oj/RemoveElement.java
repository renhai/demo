package me.renhai.oj;

/**
 * https://leetcode.com/problems/remove-element/
 * @author andy
 *
 */
public class RemoveElement {

	public static void main(String[] args) {
		int[] arr = new int[]{1,1,1,1};
//		System.arraycopy(arr, 1, arr, 0, arr.length - 1);
		
		//1241-->4211--
		int res = new RemoveElement().removeElement(arr, 1);
		System.out.println(res);
		for (int i : arr) {
			System.out.print(i);
		}

	}
	//1211
	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] == val && i < len) {
				nums[i] = nums[--len];
			}
		}
		return len;
	}

}
