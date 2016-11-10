package me.renhai.oj;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 * @author andy
 *
 */
public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
    public void push(int x) {
    	if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
        stack.push(x);
    }

    public void pop() {
    	if (stack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
    	return minStack.peek();
    }

	public static void main(String[] args) {
		MinStack st = new MinStack();
		st.push(-2);
		st.push(0);
		st.push(-1);
		System.out.println(st.getMin());
		System.out.println(st.top());
		
		st.pop();
		
		System.out.println(st.getMin());
		System.out.println(st.top());
		
//		st.pop();
//		
//		System.out.println(st.getMin());
//		System.out.println(st.top());
		
	}
	


}
