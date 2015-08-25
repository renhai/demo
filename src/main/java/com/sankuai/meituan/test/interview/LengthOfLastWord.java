package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * @author liuqian
 *
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		String sr = "hello world";
		System.out.println(new LengthOfLastWord().lengthOfLastWord2(sr));
		System.out.println(new LengthOfLastWord().lengthOfLastWord2(" "));
	}
	
    public int lengthOfLastWord(String s) {
    	s = s.trim();
        while (s.indexOf(' ') > -1) {
			s = s.substring(s.indexOf(' ') + 1, s.length());
		}
        return s.length();
    }
    
    public int lengthOfLastWord2(String s) {
    	s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }

}
