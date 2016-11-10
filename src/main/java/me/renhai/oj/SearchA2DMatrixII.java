package me.renhai.oj;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
        	return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int m = 0, n = cols - 1;
        while (m < rows && n > -1) {
        	if (matrix[m][n] == target) {
        		return true;
        	} else if (matrix[m][n] > target) {
        		n --;
        	} else {
        		m ++;
        	}
        }
        return false;
    } 

}
