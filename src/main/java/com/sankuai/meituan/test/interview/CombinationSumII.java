package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * @author andy
 *
 */
public class CombinationSumII {

	public static void main(String[] args) {
//		List<List<Integer>> res = new CombinationSumII().combinationSum2(new int[] { 14, 6, 25, 9, 30, 20, 33, 34, 28,
//				30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6,
//				32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12 }, 27);
		List<List<Integer>> res = new CombinationSumII().combinationSum2(new int[] {1,1,1}, 2);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> combs = new ArrayList<>();
    	helper(combs, new ArrayList<Integer>(), candidates, target, 0);
    	return combs;
    }
    
    private void helper(List<List<Integer>> combs, List<Integer> comb, int[] candidates, int target, int start) {
    	if (target == 0) {
			combs.add(new ArrayList<>(comb));	
    		return;
    	}
    	
    	for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
    		if (i > start && candidates[i] == candidates[i - 1]) continue;
			comb.add(candidates[i]);
			helper(combs, comb, candidates, target - candidates[i], i + 1);
			comb.remove(comb.size() - 1);
		}
    }

}
