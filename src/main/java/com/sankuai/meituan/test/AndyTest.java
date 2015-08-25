package com.sankuai.meituan.test;

import java.util.Stack;



public class AndyTest {

	public static void main(String[] args) {
    	int i = 1;
    	System.out.println(~i);
    	
    	System.out.println((int)'A');
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1);
    	Integer item = stack.pop();
    	System.out.println(item);
    	System.out.println(stack.isEmpty());
    	System.out.println(stack.pop());
	}
	
}
