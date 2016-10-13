package com.sankuai.meituan.test.interview;

import java.util.Stack;

public class CreateMaximumNumber {

	public static void main(String[] args) {
		CreateMaximumNumber cmn = new CreateMaximumNumber();
		int[] max = cmn.getMaxSubArray(new int[] {3,6,5,4,3,7}, 3);
		for (int i = 0; i < max.length; i++) {
			System.out.print(max[i] + "\t");
		}
		System.out.println();
		
		int[] res = cmn.merge(new int[]{3,3,6,1,2}, new int[]{5,8,3});
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + "\t");
		}
	}
	
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] first = getMaxSubArray(nums1, i);
            int[] sec = getMaxSubArray(nums2, k - i);
            int[] merge = merge(first, sec);
            if (isGreater(merge, 0, ans, 0)) {
                ans = merge;
            }
        }   
        return ans;
    }
    
    private int[] getMaxSubArray(int[] nums, int k) {
    	int[] res = new int[k];
    	int len = nums.length;
    	Stack<Integer> s = new Stack<>();
    	for (int i = 0; i < nums.length; i++) {
			while (!s.isEmpty() && len - i - 1 >= k - s.size() && nums[i] > s.peek()) {
				s.pop();
			}
			if (s.size() < k) {
				s.push(nums[i]);
			}
		}
    	for (int i = k - 1; i >= 0; i --) {
    		res[i] = s.pop();
    	}
    	return res;
    } 
    
    private int[] merge(int[] nums1, int[] nums2) {
    	int len = nums1.length + nums2.length;
    	int[] res = new int[len];
    	int i = 0; int j = 0; int index = 0;
    	while (i < nums1.length && j < nums2.length) {
    		if (isGreater(nums1, i, nums2, j)) {
    			res[index ++] = nums1[i ++];
    		} else {
    			res[index ++] = nums2[j ++];
    		}
    	}
    	while (i < nums1.length) {
    		res[index ++] = nums1[i ++];
    	}
    	while (j < nums2.length) {
    		res[index ++] = nums2[j ++];
    	}
    	
    	return res;
    }
    
    private boolean isGreater(int[] nums1, int start1, int[] nums2, int start2) {
    	while (start1 < nums1.length && start2 < nums2.length && nums1[start1] == nums2[start2]) {
			start1 ++;
			start2 ++;
    	}
    	//如果都相等，长度长的大
    	if (start1 == nums1.length) {
    		return false;
    	}
    	if (start2 == nums2.length) {
    		return true;
    	}
    	return nums1[start1] > nums2[start2];
    }

}
