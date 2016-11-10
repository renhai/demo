package me.renhai.oj;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public void print() {
		ListNode tmp = this;
		System.out.print("[");
		while (tmp != null) {
			System.out.print(" " + tmp.val + " ");
			tmp = tmp.next;
		}
		System.out.println("]");
	}
}
