package me.renhai.oj;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * @author andy
 *
 */
public class String2Integer {

	public static void main(String[] args) {
//		String str = "123";
//		int num = str.charAt(0) - '0';
//		System.out.println(num);
//		
//		char c = 48;
//		System.out.println(c);
		
		
		
		System.out.println(new String2Integer().myAtoi(null));
		System.out.println(new String2Integer().myAtoi(" "));
		System.out.println(new String2Integer().myAtoi("    1  23 "));
		System.out.println(new String2Integer().myAtoi("+1"));
		System.out.println(new String2Integer().myAtoi("  -0012a42"));
		System.out.println(new String2Integer().myAtoi("2147483648"));
		System.out.println(new String2Integer().myAtoi("9223372036854775809"));
		System.out.println(new String2Integer().myAtoi("-2147483648"));
	}
	
    public int myAtoi(String str) {
    	if (str == null) return 0;
    	str = str.trim();
    	if (str.length() == 0) return 0;
    	long result = 0L;
    	int sign = 1;
    	int i = 0;
    	if (str.charAt(0) == '+') {
    		sign = 1;
    		i = 1;
    	}
    	if (str.charAt(0) == '-') {
    		sign = -1;
    		i = 1;
    	}
        for (; i < str.length(); i ++) {
        	if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        		result = result * 10 + (str.charAt(i) - '0');
        		if (sign * result > Integer.MAX_VALUE) {
        			result = Integer.MAX_VALUE;
					break;
				}
        		if (sign * result < Integer.MIN_VALUE) {
					result = Integer.MIN_VALUE;
					break;
				}
			} else {
				break;
			}
		}
        result *= sign;
        return (int)result;
    }

}
