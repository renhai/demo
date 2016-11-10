package me.renhai.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumII {

	public static void main(String[] args) {
		
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<>();
    	for (List<Integer> numbers : treeSumWithPath(root)) {
    		int numSum = 0;
    		for (Integer num : numbers) {
				numSum += num;
			}
    		if (sum == numSum) {
    			res.add(numbers);
    		}
    	}
    	return res;
    }
    
    private List<List<Integer>> treeSumWithPath(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if (root == null) {
    		return res;
    	}
    	if (root.left == null && root.right == null) {
    		List<Integer> numbers = new ArrayList<>();
    		numbers.add(root.val);
    		res.add(numbers);
    		return res;
    	}
    	for (List<Integer> numbers : treeSumWithPath(root.left)) {
    		List<Integer> list = new ArrayList<>();
    		list.add(root.val);
    		list.addAll(numbers);
    		res.add(list);
    	}
    	
    	for (List<Integer> numbers : treeSumWithPath(root.right)) {
    		List<Integer> list = new ArrayList<>();
    		list.add(root.val);
    		list.addAll(numbers);
    		res.add(list);
    	}
    	return res;
    }

}
