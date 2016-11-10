package me.renhai.oj;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {5,6,1,2,7,4,3,8};
//		new QuickSort().quickSort(nums);
//		for (int i : nums) {
//			System.out.print(i + " ,");
//		}
//		System.out.println();
		
		int rs = new QuickSort().findKthLargest(nums, 4);
		System.out.println(rs);
		for (int i : nums) {
			System.out.print(i + " ,");
		}
	}
	
	public int findKthLargest(int[] nums, int k) {
		return findKthLargest(nums, k, 0, nums.length - 1);
	}
	
	private int findKthLargest(int[] nums, int k, int left, int right) {
		int pos = partition(nums, left, right);
		int len = right - pos + 1;
		if (k == len) {
			return nums[pos];
		} else if (k > len) {
			return findKthLargest(nums, k - len, left, pos - 1);
		} else {
			return findKthLargest(nums, k, pos + 1, right);
		}
	}
	
	public void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
	public void quickSort(int[] nums, int left, int right) {
		if (left < right) {
			int pos = partition(nums, left, right);
			quickSort(nums, left, pos - 1);
			quickSort(nums, pos + 1, right);
		}
	}
	
	
	private int partition(int[] nums, int start, int end) {
		int pivot = start;
		int left = start + 1;
		int right = end;
		while (left <= right) {
			while (left <= right && nums[left] < nums[pivot]) {
				left ++;
			}
			while (left <= right && nums[right] >= nums[pivot]) {
				right --;
			}
			if (left < right) {
				swap(nums, left, right);
			}
		}
		swap(nums, pivot, right);
		return right;
	}
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
