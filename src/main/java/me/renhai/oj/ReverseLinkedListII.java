package me.renhai.oj;

public class ReverseLinkedListII {

	public static void main(String[] args) {

	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode prev = dummy;
    	ListNode curr = null;
    	ListNode next = null;
    	for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}
    	curr = prev.next;
    	next = curr.next;
    	for (int i = 0; i < n - m; i++) {
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
			next = curr.next;
		}
    	return dummy.next;
    }

}
