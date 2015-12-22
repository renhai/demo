package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * @author andy
 *
 */
public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {

	}
	
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	list.addFirst(node.val);
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        }
        return list;
    }
    
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }
    
    private void traversal(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	traversal(root.left, list);
    	traversal(root.right, list);
    	list.add(root.val);
    }

}
