package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @author andy
 *
 */
public class KthSmallestElementInABST {

	public static void main(String[] args) {

	}
	
	private int count;
	private int ret;
	
    public int kthSmallest(TreeNode root, int k) {
    	count = k;
    	helper(root);
        return ret;
    }
    private void helper(TreeNode root) {
    	if (root == null) return;
    	helper(root.left);
    	count --;
    	if (count == 0) {
    		ret = root.val;
    		return;
    	}
    	
    	helper(root.right);
    }
	
	//method 1
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper1(root, list, k);
        return list.get(k - 1);
    }
    private void helper1(TreeNode root, List<Integer> list, int k) {
    	if (root == null) return;
    	if (list.size() == k) return;
    	helper1(root.left, list, k);
    	list.add(root.val);
    	helper1(root.right, list, k);
    }

}
