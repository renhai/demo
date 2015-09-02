package com.sankuai.meituan.test.interview;

public class BinaryTreeSolution {

	public static void main(String[] args) {
		
	}
	
	/**
	 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
	 * @param root
	 * @return
	 */
    public int maxDepth(TreeNode root) {
        if (root == null) {
			return 0;
		}
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
