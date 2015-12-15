package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum/
 * @author andy
 *
 */
public class PathSum {

	public static void main(String[] args) {

	}
	
	// better
    public boolean hasPathSumII(TreeNode root, int sum) {
    	if (root == null) {
    		return false;
    	}
    	if (root.left == null && root.right == null) {
    		return root.val == sum;
    	}
    	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	for (int val : treeSum(root)) {
    		if (sum == val) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private List<Integer> treeSum(TreeNode root) {
    	List<Integer> sumList = new ArrayList<Integer>();
    	if (root == null) {
    		return sumList;
    	}
    	if (root.right == null && root.left == null) {
    		sumList.add(root.val);
    		return sumList;
    	}
    	for (int val : treeSum(root.left)) {
    		sumList.add(root.val + val);
    	}
    	
       	for (int val : treeSum(root.right)) {
    		sumList.add(root.val + val);
    	}
       	return sumList;
    }
    
}
