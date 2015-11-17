package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author andy
 *
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		List<List<Integer>> result = new PascalsTriangle().generate(9);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}
	
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
			return result;
		}
        for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
				}
			}
			result.add(row);
		}
        return result;
    }

}
