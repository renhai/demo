package me.renhai.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class AndyTest {

	public static void main(String[] args) {
		AndyTest at = new AndyTest();
		System.out.println(at.strobogrammaticInRange("50", "100"));
		
		System.out.println("96".compareTo("50"));
		System.out.println("96".compareTo("100"));
		
		System.out.println(at.firstUniqChar("leetcode"));
		
		System.out.println(at.lexicalOrder(346));
	}
    public char findTheDifference(String s, String t) {
        char res = s.charAt(0);
        for (int i = 1; i < s.length(); i ++) {
            res ^= s.charAt(i);
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (map[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 1) return res;
        for (int i = 1; i < 10; i ++) {
            helper(n, i, res);
        }
        return res;
    }
    
    private void helper(int n, int curr, List<Integer> res) {
        if (curr > n) return;
        res.add(curr);
        for (int i = 0; i < 10; i ++) {
            helper(n, curr * 10 + i, res);
        }
    }
	
	
    public int strobogrammaticInRange(String low, String high) {
        List<String> all = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i ++) {
            all.addAll(helper(i, i));
        }
        int count = 0;
        for (String stro : all) {
            if (stro.compareTo(low) >= 0 && stro.compareTo(high) <= 0) {
                count ++;
            } 
        }
        return count;
    }
    
    private List<String> helper(int len, int maxLen) {
        if (len == 0) {
            return Arrays.asList("");
        }
        if (len == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> list = helper(len - 2, maxLen);
        List<String> res = new ArrayList<>();
        for (String str : list) {
            if (len != maxLen) {
                res.add("0" + str + "0");
            }
            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }
        return res;
    }

	
	void print2D(char[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}
	void print2D(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}
	
	
	

    
}


