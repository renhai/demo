package com.sankuai.meituan.test;

import java.text.DecimalFormat;
import java.util.LinkedList;
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
//    	System.out.println(stack.pop());
    	
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	ll.add(11);
    	ll.add(12);
    	while (!ll.isEmpty()) {
			System.out.print(ll.poll() + "\t");
		}
    	System.out.println();
    	
//    	DecimalFormat df = new DecimalFormat("00");
//    	for (int j = 1; j <= 50; j++) {
//    		System.out.println("INSERT INTO `meituanpoiop`.`zb_user_exchange` (`user_id`, `user_name`, `invite_code`) VALUES ('"+-j+"', '美团高校"+df.format(j)+"', '美团高校"+df.format(j)+"');");
//		}
    	
    	System.out.println(1L << 31);
    	
	}
	
}
