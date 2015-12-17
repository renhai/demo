package com.sankuai.meituan.test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.sankuai.meituan.test.interview.ListNode;



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
    	
    	try {
			List<String> lines = FileUtils.readLines(new File("/Users/andy/Downloads/user_id.txt"));
			System.out.println(StringUtils.join(lines, ","));
			System.out.println(lines.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
    	queue.offer(1); 
    	queue.offer(3);
    	queue.offer(2);
    	
    	Integer val = null;
    	while( (val = queue.poll()) != null) {
    	    System.out.println(val);
    	}
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null) return head;
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = curr.next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	private ListNode reverseII(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev = dummy;
		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}
		ListNode curr = prev.next;
		ListNode next = curr.next;
		for (int i = 0; i < n - m; i++) {
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
			next = curr.next;
		}
		
		return dummy.next;
	}
	
}
