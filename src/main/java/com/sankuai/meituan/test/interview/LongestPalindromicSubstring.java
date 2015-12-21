package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author andy
 *
 */
public class LongestPalindromicSubstring {

	private int lo;
	private int maxlen;
	
    public String longestPalindrome(String s) {
    	if (s == null || s.length() < 2) {
    		return s;
    	}
    	for (int i = 0; i < s.length() - 1; i ++) {
    		helper(s, i, i);
    		helper(s, i, i + 1);
    	}
    	
        return s.substring(lo, lo + maxlen);
    }
    
    private void helper(String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left --;
    		right ++;
    	}
    	if (maxlen < right - left - 1) {
    		lo = left + 1;
    		maxlen = right - left - 1;
    	}
    }

    public static void main(String[] args) {
    	
    }
}
