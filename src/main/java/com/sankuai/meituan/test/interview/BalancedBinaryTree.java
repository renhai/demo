package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * @author andy
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {

	}
	
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height (TreeNode root) {
    	if (root == null) return 0;
    	return Math.max(height(root.right), height(root.left)) + 1;
    }

}
