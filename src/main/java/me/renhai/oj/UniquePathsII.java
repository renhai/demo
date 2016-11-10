package me.renhai.oj;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * @author andy
 *
 */
public class UniquePathsII {

	public static void main(String[] args) {

	}
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        obstacleGrid[0][0] ^= 1;
        for (int i = 1; i < rows; i ++) {
        	obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
        }
        
        for (int i = 1; i < cols; i ++) {
        	obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
        }
        
        for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
			}
		}
        return obstacleGrid[rows - 1][cols - 1];
    }

}
