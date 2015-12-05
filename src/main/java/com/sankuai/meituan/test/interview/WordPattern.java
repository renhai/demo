package com.sankuai.meituan.test.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * 
 * @author andy
 *
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * pattern = "abba", str = "dog cat cat dog" should return true.
	pattern = "abba", str = "dog cat cat fish" should return false.
	pattern = "aaaa", str = "dog cat cat dog" should return false.
	pattern = "abba", str = "dog dog dog dog" should return false.
	 */
    public boolean wordPattern(String pattern, String str) {
    	Map<Character, String> map = new HashMap<>();
    	String[] strArr = str.split(" ");
    	if (strArr.length != pattern.length())
    		return false;
    	map.put(pattern.charAt(0), strArr[0]);
    	for (int i = 1; i < pattern.length(); i++) {
			String s = map.get(pattern.charAt(i));
			if (s != null) {
				if (!strArr[i].equals(s)) {
					return false;
				}
			} else {
				if (map.containsValue(strArr[i])) {
					return false;
				}
				map.put(pattern.charAt(i), strArr[i]);
			}
			
		}
    	return true;
    }

}
