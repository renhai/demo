package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * @author andy
 *
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {

	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
    	if (root == null) return res;
    	TreeNode curr = root;
    	Stack<TreeNode> stack = new Stack<>();
    	while (curr != null || !stack.isEmpty()) {
    		while (curr != null) {
    			stack.push(curr);
    			curr = curr.left;
    		}
    		TreeNode node = stack.pop();
    		res.add(node.val);
    		curr = node.right;
    	}
    	return res;
    }
	
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
    
    private void traversal(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	traversal(root.left, list);
    	list.add(root.val);
    	traversal(root.right, list);
    }

}
