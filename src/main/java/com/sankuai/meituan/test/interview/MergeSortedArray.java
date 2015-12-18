package com.sankuai.meituan.test.interview;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,0,0,0};
		int m = 3;
		int[] B = new int[] {1,2};
		int n = 2;
		new MergeSortedArray().merge(A, m, B, n);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
	/**
	 * https://leetcode.com/problems/merge-sorted-array/
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >=0) {
			if (nums1[i] > nums2[j]) {
				nums1[k --] = nums1[i --];
			} else {
				nums1[k --] = nums2[j --];
			}
		}
		while (j >= 0) {
			nums1[k --] = nums2[j--];
		}
	}

}
