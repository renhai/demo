package com.sankuai.meituan.test.interview;

public class FullSort {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		do {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}
			System.out.println();
		} while (new FullSort().nextPermutation(arr));

	}

	public boolean nextPermutation(int[] arr) {
		int postLeft = -1;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				postLeft = i - 1;
				break;
			}
		}
		if (postLeft < 0) {
			return false;
		}

		int postRight = -1;
		for (int i = arr.length - 1; i >= postLeft; i--) {
			if (arr[i] > arr[postLeft]) {
				postRight = i;
				break;
			}
		}
		swap(arr, postLeft, postRight);
		reverse(arr, postLeft + 1, arr.length);
		return true;
	}

	public void swap(int[] arr, int ind1, int ind2) {
		int t = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = t;
	}

	public void reverse(int[] arr, int ind1, int ind2) {
		for (int i = 0; i < (ind2 - ind1) / 2; i++) {
			swap(arr, ind1 + i, ind2 - 1 - (i));
		}
	}
}
