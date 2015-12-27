package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * @author andy
 *
 */
public class CombinationSum {

	public static void main(String[] args) {
		List<List<Integer>> res = new CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> combs, List<Integer> comb, int[] candidates, int target, int start) {
    	if (target == 0) {
    		combs.add(new ArrayList<>(comb));
    		return;
    	}
    	
    	for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
			comb.add(candidates[i]);
			helper(combs, comb, candidates, target - candidates[i], i);
			comb.remove(comb.size() - 1);
		}
    	
    }

}
