package me.renhai.oj;

/**
 * https://leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author andy
 *
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome2(1221));
		System.out.println(new PalindromeNumber().isPalindrome2(12221));
		System.out.println(new PalindromeNumber().isPalindrome2(12231));
//		System.out.println(new PalindromeNumber().isPalindrome2(2147483647));
	}
	
    public boolean isPalindrome(int x) {
    	if (x < 0) {
			return false;
		}
    	int rev = reverse(x);
    	return rev == x;
    }
    //123 --> 321
    public int reverse(int x) {
    	long result = 0L;
    	while (x != 0) {
    		result = result * 10 + x % 10;
    		x = x / 10;
    	}

    	return (int)result;
    }
    
    /**
     * better way
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
    	if (x < 0) {
			return false;
		}
    	int rev = 0;
    	while (x > rev) {
    		rev = rev * 10 + x % 10;
    		x = x / 10;
    		System.out.println("rev: " + rev + " --> x: " + x);
    	}
    	return x == rev || x == rev / 10;
    }
    

}
