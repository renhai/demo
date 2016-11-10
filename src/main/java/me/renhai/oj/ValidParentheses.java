package me.renhai.oj;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author andy
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()[]{}"));
		System.out.println(new ValidParentheses().isValid("([)]"));
		System.out.println(new ValidParentheses().isValid("(]"));
		System.out.println(new ValidParentheses().isValid("{}{{}}"));
		System.out.println(new ValidParentheses().isValid("([])"));
	}
    public boolean isValid(String s) {
    	if (s.length() % 2 != 0) {
			return false;
		}
//    	char prev = s.charAt(0);
//        for (int i = 1; i < s.length(); i++) {
//        	if (prev == '(' && s.charAt(i) == ')') {
//        		if (++i < s.length()) {
//        			prev = s.charAt(i);
//				}
//			} else if (prev == '[' && s.charAt(i) == ']') {
//				if (++i < s.length()) {
//					prev = s.charAt(i);
//				}
//			} else if (prev == '{' && s.charAt(i) == '}') {
//				if (++i < s.length()) {
//					prev = s.charAt(i);
//				}
//			} else {
//				return false;
//			}
//		}
    	Stack<Character> stack = new Stack<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			}	else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			}	else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
//    		else {
//				if (!stack.isEmpty()) {
//					char p = stack.peek();
//					if ((p == '(' && c == ')') || (p == '[' && c == ']') || (p == '{' && c == '}')) {
//						stack.pop();
//					}
//				}
//			}
		}
        return stack.isEmpty();
    }

}
