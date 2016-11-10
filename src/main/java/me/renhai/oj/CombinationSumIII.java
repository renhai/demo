package me.renhai.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * @author andy
 *
 */
public class CombinationSumIII {

	public static void main(String[] args) {
		List<List<Integer>> res = new CombinationSumIII().combinationSum3(3, 7);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
	
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[] {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> combs = new ArrayList<>();
        helper(combs, new ArrayList<Integer>(), candidates, n, 0, k);
        return combs;
    }
    
    private void helper(List<List<Integer>> combs, List<Integer> comb, int[] candidates, int target, int start, int k) {
    	if (target == 0 && comb.size() == k) {
			combs.add(new ArrayList<>(comb));	
    		return;
    	}
    	
    	for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
			comb.add(candidates[i]);
			helper(combs, comb, candidates, target - candidates[i], i + 1, k);
			comb.remove(comb.size() - 1);
		}
    }

}
