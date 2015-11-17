package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * @author andy
 *
 */
public class PascalsTriangleII {

	public static void main(String[] args) {
		List<Integer> res = new PascalsTriangleII().getRow(0);
		System.out.println(res);
	}
	
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> lastOne = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
        	List<Integer> row = new ArrayList<>();
        	for (int j = 0; j < i + 1; j++) {
        		if (j == 0 || j == i) {
        			row.add(1);
        		} else {
        			row.add(lastOne.get(j - 1) + lastOne.get(j));
        		}
			}
        	lastOne = row;
		}
        return lastOne;
    }

}
