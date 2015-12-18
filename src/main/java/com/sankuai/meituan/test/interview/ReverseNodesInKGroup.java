package com.sankuai.meituan.test.interview;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author andy
 *
 */
public class ReverseNodesInKGroup {

	public static void main(String[] args) {

	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null || head.next == null || k == 1) {
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode pre = dummy;
    	int i = 0;
    	while (head != null) {
    		i ++;
    		if (i % k == 0) {
    			pre = reverseBetween(pre, head.next);
    			head = pre.next;
    		} else {
    			head = head.next;
    		}
    	}
        return dummy.next;
    }
    
    
    public ListNode reverseBetween(ListNode begin, ListNode end) {
    	ListNode pre = begin;
    	ListNode curr = pre.next;
    	ListNode next = curr.next;
    	while (next != end) {
    		curr.next = next.next;
    		next.next = pre.next;
    		pre.next = next;
    		next = curr.next;
    	}
        return curr;
    }
}
