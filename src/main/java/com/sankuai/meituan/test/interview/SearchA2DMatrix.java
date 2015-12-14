package com.sankuai.meituan.test.interview;

public class SearchA2DMatrix {

	public static void main(String[] args) {

	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0) {
    		return false;
    	}
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	int start = 0;
    	int end = rows * cols - 1;
    	while (start <= end) {
    		int mid = (start + end) / 2;
    		if (matrix[mid / cols][mid % cols] == target) {
    			return true;
    		} else if (matrix[mid / cols][mid % cols] < target) {
    			start = mid + 1;
    		} else {
    			end = mid - 1;
    		}
    	}
    	return false;
    }

}
