package me.renhai.oj;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
 * @author andy
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(9);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(6);
//		head1.next.next.next = new ListNode(8);
		
		ListNode head2 = new ListNode(0);
//		head2.next = new ListNode(9);
//		head2.next.next = new ListNode(4);
		
		head1.print();
		head2.print();
		
		ListNode res = new AddTwoNumbers().addTwoNumbers(head1, head2);
		res.print();
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null || l2 == null) {
			return null;
		}
    	ListNode res = new ListNode(0);
    	ListNode head = res;
    	int jinwei = 0;
    	while(l1 != null || l2 != null) {
    		int val1 = l1 == null ? 0 : l1.val;
    		int val2 = l2 == null ? 0 : l2.val;
    		int di = (val1 + val2 + jinwei) % 10;
    		jinwei = (val1 + val2 + jinwei) / 10;
    		res.next = new ListNode(di);
    		
    		l1 = l1 == null ? l1 : l1.next;
    		l2 = l2 == null ? l2 : l2.next;
    		res = res.next;
    	}
    	if (jinwei > 0 ) {
			res.next = new ListNode(jinwei);
		}
        return head.next;
    }

}
