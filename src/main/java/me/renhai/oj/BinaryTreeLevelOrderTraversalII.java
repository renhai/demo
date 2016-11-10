package me.renhai.oj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @author andy
 *
 */
public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {

	}
	
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) return result;
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		List<Integer> levelList = new ArrayList<>();
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
				if (queue.peek().left != null) {
					queue.offer(queue.peek().left);
				}
				if (queue.peek().right != null) {
					queue.offer(queue.peek().right);
				}
				levelList.add(queue.poll().val);
			}
    		result.add(0, levelList);
    	}
    	return result;
    }
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
    		list.add(0, values);//change
    	}
    	List<Integer> values = list.get(list.size() - level - 1);//change
    	values.add(root.val);
    	traversal(root.left, level + 1, list);
    	traversal(root.right, level + 1, list);
    }

}
