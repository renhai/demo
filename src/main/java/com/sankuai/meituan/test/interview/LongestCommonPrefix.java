package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author andy
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String str = "test";
		System.out.println(str.substring(0));
		System.out.println(str.substring(0, str.length() - 1));
		String[] strs = new String[] {"abcddddd", "abddd", "aasfd"};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));

	}
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) {
			return "";
		}
    	String pre = strs[0];
    	for (int i = 1; i < strs.length; i++) {
    		while (strs[i].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
			}
		}
    	return pre;
    }
}
