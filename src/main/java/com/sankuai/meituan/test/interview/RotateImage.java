package com.sankuai.meituan.test.interview;
/**
 * https://leetcode.com/problems/rotate-image/
 * 1 2 3    7 4 1
 * 4 5 6 -- 8 5 2
 * 7 8 9	9 6 3
 * 	 |
 * 7 8 9
 * 4 5 6
 * 1 2 3
 *   |
 * 7 4 1
 * 8 5 2
 * 9 6 3
 * 
 * @author andy
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
		new RotateImage().printMatrix(matrix);
		new RotateImage().rotate(matrix);
	}
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
        	int[] tmp = matrix[i];
        	matrix[i] = matrix[matrix.length - i - 1];
        	matrix[matrix.length - i - 1] = tmp;
		}
        
        printMatrix(matrix);
        
        for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
        
        printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
        System.out.println();
    }
}
