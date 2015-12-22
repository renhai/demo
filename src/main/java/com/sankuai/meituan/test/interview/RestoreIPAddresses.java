package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * @author andy
 *
 */
public class RestoreIPAddresses {

	public static void main(String[] args) {
		String s = "0279245587303";
		List<String> res = new RestoreIPAddresses().restoreIpAddresses(s);
		System.out.println(res);
	}
	
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
        	return res;
        }
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < len; k++) {
					String s1 = s.substring(0, i);
					String s2 = s.substring(i, j);
					String s3 = s.substring(j, k);
					String s4 = s.substring(k, len);
					if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
        return res;
    }
    
    private boolean isValid (String part) {
    	if (part.length() == 0) return false;
    	if (part.length() > 3) return false;
    	if (part.charAt(0) == '0' && part.length() > 1) return false;
    	if (Integer.parseInt(part) > 255) return false;
    	return true;
    }

}
