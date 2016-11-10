package me.renhai.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * @author andy
 *
 */
public class Combinations {

	public static void main(String[] args) {
		List<List<Integer>> res = new Combinations().combine(4, 3);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}
	
	//https://leetcode.com/discuss/31250/backtracking-solution-java
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		helper(combs, new ArrayList<Integer>(), n, k, 1);
		return combs;
	}
	
	public void helper(List<List<Integer>> combs, List<Integer> comb, int n, int k, int start) {
		if (k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for (int i = start; i <= n; i++) {
			comb.add(i);
			helper(combs, comb, n, k - 1, i + 1);
			comb.remove(comb.size() - 1);
		}
	}
	

}
