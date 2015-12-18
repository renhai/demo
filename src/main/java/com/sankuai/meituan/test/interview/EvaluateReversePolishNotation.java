package com.sankuai.meituan.test.interview;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @author andy
 *
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
//		String[] tokens = new String[] {"2", "1", "+", "3", "*"};
		String[] tokens = new String[] {"4", "13", "5", "/", "+"};
		int result = new EvaluateReversePolishNotation().evalRPN(tokens);
		System.out.println(result);
	}
//	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<>();
    	for (int i = 0; i < tokens.length; i++) {
    		if ("+".equals(tokens[i])) {
    			int result = stack.pop() + stack.pop();
    			stack.push(result);
    		} else if ("-".equals(tokens[i])) {
    			int result = - (stack.pop() - stack.pop());
    			stack.push(result);
    		} else if ("*".equals(tokens[i])) {
    			int result = stack.pop() * stack.pop();
    			stack.push(result);
    		} else if ("/".equals(tokens[i])) {
    			int second = stack.pop();
    			int first = stack.pop();
    			int result = first / second;
    			stack.push(result);
    		} else {
    			stack.push(Integer.parseInt(tokens[i]));
    		}
		}
        return stack.pop();
    }

}
