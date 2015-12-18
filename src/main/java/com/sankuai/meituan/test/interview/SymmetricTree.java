package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * @author andy
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(3);
        List<Integer> list = new ArrayList<>();
        
		new SymmetricTree().traversal(root, list);
		for (Integer integer : list) {
			System.out.println(integer);
		}
				
		System.out.println(root.val);
		System.out.println(new SymmetricTree().isSymmetric(root));
	}

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
//        if (root.left == null && root.right == null) return true;
//        if (root.left == null || root.right == null) return false;
//        if (root.left.val != root.right.val) return false;
//        
//        List<Integer> list = new ArrayList<>();
//        traversal(root, list);
//        if (list.size() % 2 == 0) return false;
//        int begin = 0, end = list.size() - 1;
//        while (begin < end) {
//        	if (!list.get(begin ++).equals(list.get(end --))) {
//        		return false;
//        	}
//        }
//        return true;
    }
    
    private void traversal(TreeNode root, List<Integer> list) {
    	if (root.left != null) {
    		traversal(root.left, list);
    	}
    	list.add(root.val);
    	if (root.right != null) {
    		traversal(root.right, list);
    	}
    }
    
	private boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val) {
			return false;
		} else {
			return isMirror(left.left, right.right) && isMirror(left.right, right.left);
		}
	}
}
