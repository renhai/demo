package me.renhai.oj;


public class ValidAnagram {

	public static void main(String[] args) {

	}
	
	/**
	 * https://leetcode.com/problems/valid-anagram/
	 * Given two strings s and t, write a function to determine if t is an anagram of s.
	 * For example,
	 * s = "anagram", t = "nagaram", return true.
	 * s = "rat", t = "car", return false.
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()) {
			return false;
		}
    	int[] alphabet = new int[26];
    	for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a'] ++;
		}
    	for (int i = 0; i < t.length(); i++) {
    		alphabet[t.charAt(i) - 'a'] --;
		}
    	for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] != 0) {
				return false;
			}
		}
    	return true;
    }

}
