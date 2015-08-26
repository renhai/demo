package com.sankuai.meituan.test.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * @author andy
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
//		head.next.next.next.next = new ListNode(3);
		head.print();
		ListNode res = new RemoveDuplicatesFromSortedList().deleteDuplicatesII(head);
		res.print();
	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode res = head;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
        	if (curr.val == curr.next.val) {
        		curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
        return res;
    }
    
//  Given 1->2->3->3->4->4->5, return 1->2->5.
//  Given 1->1->1->2->3, return 2->3.
    //TODO
    public ListNode deleteDuplicatesII(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	Set<Integer> set = new HashSet<Integer>();
    	ListNode res = new ListNode(0);
    	res.next = head;
    	while (res != null && res.next != null) {
    		if (set.contains(res.next.val)) {
    			set.add(res.next.val);
    			res.next = res.next.next;
			} else {
				set.add(res.next.val);
				res = res.next;
			}
    	}

    	return head;
    	
    }

}
