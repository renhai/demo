package me.renhai.oj;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * @author andy
 *
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {

	}
	
    public boolean isValidBST(TreeNode root) {
    	if (root == null) return false;
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode curr = root;
    	TreeNode pre = null;
    	while (curr != null || !stack.isEmpty()) {
    		while (curr != null) {
    			stack.push(curr);
    			curr = curr.left;
    		}
    		TreeNode node = stack.pop();
    		if (pre != null && pre.val > node.val) {
    			return false;
    		} 
    		pre = node;
    		curr = node.right;
    	}
    	return true;
    }

}
