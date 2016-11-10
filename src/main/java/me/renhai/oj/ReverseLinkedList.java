package me.renhai.oj;

public class ReverseLinkedList {

	public static void main(String[] args) {

	}
	
    public ListNode reverseList(ListNode head) {
    	ListNode curr = head;
    	ListNode prev = null;
    	ListNode next = null;
    	while (curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	return prev;
    }
    
    public ListNode reverseList2(ListNode head) {
        if (head == null) return head;

    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode prev = dummy;
    	ListNode curr = prev.next;
    	ListNode next = curr.next;
    	while (next != null) {
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
			next = curr.next;
		}
    	return dummy.next;
    }

}
