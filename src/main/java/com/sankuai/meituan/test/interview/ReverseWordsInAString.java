package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * @author andy
 *
 */
public class ReverseWordsInAString {
	
	public static void main(String[] args) {
//		String s = "the sky is       blue";
		String s = " ";
//		System.out.println(s.replaceAll("\\s+", " "));
		String res = new ReverseWordsInAString().reverseWordsII(s);
		System.out.println(res);
	}
	
    public String reverseWordsII(String s) {
    	if (s == null) {
    		return s;
    	}
    	String[] arr = s.trim().split("\\s+");
    	StringBuilder sb = new StringBuilder();
    	for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
			if (i > 0) {
				sb.append(" ");
			} 
		}
    	return sb.toString();
    }
	
    public String reverseWords(String s) {
    	if (s == null) {
    		return s;
    	}
    	s = s.trim();
    	s = s.replaceAll("[ ]+", " ");
    	if (s.length() <= 1) {
    		return s;
    	}
    	char[] arr = s.toCharArray();
    	reverse(arr, 0, arr.length - 1);
    	int begin = 0, end = 0;
    	for (int i = 0; i < arr.length; i ++) {
    		if (arr[i] == ' ') {
    			end = i - 1;
    			reverse(arr, begin, end);
    			begin = i + 1;
    		} else if (i == arr.length - 1) {
    			end = i;
    			reverse(arr, begin, end);
    		}
    	}
    	return new String(arr);
    }
    
    private void reverse(char[] arr, int begin, int end) {
    	while (begin < end) {
    		char c = arr[begin];
    		arr[begin] = arr[end];
    		arr[end] = c;
    		begin ++;
    		end -- ;
    	}
    }

}
