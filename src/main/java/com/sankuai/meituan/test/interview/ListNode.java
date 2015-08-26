package com.sankuai.meituan.test.interview;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
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
