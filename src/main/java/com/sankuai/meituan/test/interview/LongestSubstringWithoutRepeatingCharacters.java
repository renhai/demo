package com.sankuai.meituan.test.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author andy
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String a = "abba";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(a));
	}
	
    public int lengthOfLongestSubstring(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	int start = 0;
    	int maxlen = 0;
    	for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				start = Math.max(map.get(c) + 1, start);//pay more attention
			} 
			maxlen = Math.max(i - start + 1, maxlen);
			map.put(c, i);
		}
        return maxlen;
    }

}
