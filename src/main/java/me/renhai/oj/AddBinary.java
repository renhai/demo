package me.renhai.oj;

/**
 * https://leetcode.com/problems/add-binary/
 * Given two binary strings, return their sum (also a binary string).
	For example,
	a = "11"
	b = "1"
	Return "100".
 * @author andy
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		System.out.println(new AddBinary().addBinary(a, b));
	}
	
    public String addBinary(String a, String b) {
    	StringBuilder sb = new StringBuilder();
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	int jinwei = 0;
    	while (i >= 0 || j >= 0) {
    		int sum = 0;
    		if (i >= 0) {
				sum += a.charAt(i) - '0';
				i --;
			}
    		if (j >= 0) {
				sum += b.charAt(j) - '0';
    			j --;
			}
    		sb.insert(0, (sum + jinwei) % 2);
    		jinwei = (sum + jinwei) / 2;
    	}
    	if (jinwei > 0) {
    		sb.insert(0, jinwei);
		}
    	return sb.toString();
    }

}
