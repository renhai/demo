package me.renhai.oj;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * @author andy
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {

	}
	
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
        	max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        	if (height[left] < height[right]) {
        		left ++;
        	} else {
        		right --;
        	}
        }
        return max;
    }

}
