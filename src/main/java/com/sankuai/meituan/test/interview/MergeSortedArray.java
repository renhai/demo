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
	//TODO
	public void merge(int[] A, int m, int[] B, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i > -1 && j > -1)
			A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
		while (j > -1)
			A[k--] = B[j--];

	}

}
