package me.renhai.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * @author andy
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {

	}
	
    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals == null || intervals.size() <= 1) {
    		return intervals;
    	}
        Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
        List<Interval> res = new ArrayList<>();
        Interval pre = null;
        for (Interval curr : intervals) {
			if (pre == null || curr.start > pre.end) {
				res.add(curr);
				pre = curr;
			} else if (curr.start <= pre.end) {
				pre.end = Math.max(pre.end, curr.end);
			} 
		}

        return res;
    }

}
