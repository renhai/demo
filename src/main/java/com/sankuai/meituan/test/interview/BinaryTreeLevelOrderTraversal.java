package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author andy
 *
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {

	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	traversal(root, 0, res);
    	
    	return res;
    }
    
    private void traversal(TreeNode root, int level, List<List<Integer>> list) {
    	if (root == null) {
    		return;
    	}
    	if (list.size() <= level) {
    		List<Integer> values = new ArrayList<>();
    		list.add(values);
    	}
    	List<Integer> values = list.get(level);
    	values.add(root.val);
    	traversal(root.left, level + 1, list);
    	traversal(root.right, level + 1, list);
    }

}
