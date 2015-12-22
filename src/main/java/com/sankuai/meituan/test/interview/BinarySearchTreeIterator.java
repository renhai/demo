package com.sankuai.meituan.test.interview;

import java.util.Stack;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {

	}
	
	

}

class BSTIterator {

	private TreeNode curr;
	private Stack<TreeNode> stack;
	
    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while (curr != null) {
        	stack.push(curr);
        	curr = curr.left;
        }
        TreeNode node = stack.pop();
        int ret = node.val;
        curr = node.right;
        return ret;
    }
}
