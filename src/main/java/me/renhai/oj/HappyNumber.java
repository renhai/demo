package me.renhai.oj;

/**
 * https://leetcode.com/problems/happy-number/
 * @author andy
 *
 */
public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(12));
	}
	
    public boolean isHappy(int n) {
    	int curr = n;
    	int next = n;
        while (curr > 1) {
        	curr = cal(curr);
        	if (curr == 1) {
				return true;
			}
        	next = cal(cal(next));
        	if (next == 1) {
				return true;
			}
        	if (curr == next) {
				return false;
			}
        }
        return true;
    } 
    
	private int cal(int n) {
		int res = 0;
		while (n > 0) {
			int d = n % 10;
			res += d * d;
			n /= 10;
		}
		return res;
	}

}
