package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * @author andy
 *
 */
public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {

	}
	
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>(); 
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	list.add(node.val);
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        }
        return list;
    }
	
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }
    
    private void traversal(TreeNode root, List<Integer> list) {
    	if (root == null) {
			return;
		}
    	list.add(root.val);
    	traversal(root.left, list);
    	traversal(root.right, list);
    } 

}
