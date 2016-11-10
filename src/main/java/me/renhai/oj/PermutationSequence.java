package me.renhai.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * @author andy
 *
 */
public class PermutationSequence {

	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(4, 13));
		System.out.println(new PermutationSequence().getPermutation2(4, 13));
	}
	
	public String getPermutation2(int n, int k) {
		List<Integer> numbers = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		int[] factors = new int[n];
		factors[0] = 1;
		for (int i = 1; i < factors.length; i++) {
			factors[i] = factors[i - 1] * i;
		}
		k --;
		StringBuilder sb = new StringBuilder();
		for (int i = n; i > 0; i --) {
			int index = k / factors[n - 1];
			k = k % factors[n - 1];
			sb.append(numbers.get(index));
			numbers.remove(index);
		}
		return sb.toString();
	}
	
	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	//Time Limit Exceeded 
    public String getPermutation(int n, int k) {
    	int[] nums = new int[n];
    	for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
        for (int count = 0; count < k - 1; count++) {
			int index = nums.length - 1;
			while (index > 0) {
				if (nums[index - 1] < nums[index]) {
					break;
				}
				index--;
			}
			if (index == 0) {
				reverse(nums, 0, nums.length - 1);
			} else {
				for (int i = nums.length - 1; i >= index; i--) {
					if (nums[i] > nums[index - 1]) {
						swap(nums, index - 1, i);
						break;
					}
				}
				reverse(nums, index, nums.length - 1);
			} 
		}
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
			sb.append(i);
		}
        return sb.toString();
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
