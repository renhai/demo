package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author andy
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		List<String> res = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
		for (String string : res) {
			System.out.println(string);
		}
	}
	
    public List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<>();
    	if (digits == null || digits.length() == 0) return res;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
			res = combine(res, map[digits.charAt(i) - '0']);
		}
        return res;
    }
    
    private List<String> combine(List<String> list, String str) {
    	List<String> res = new ArrayList<>();
    	for (int i = 0; i < str.length(); i++) {
    		for (String item : list) {
    			res.add(item + str.charAt(i));
			}
		}
    	return res;
    }

}
