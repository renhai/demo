package me.renhai.oj;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * @author andy
 *
 */
public class MergeKSortedLists {

	public static void main(String[] args) {

	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
			
		});
        
        for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!queue.isEmpty()) {
        	ListNode node = queue.poll();
        	tail.next = node;
        	tail = tail.next;
        	
        	if (node.next != null) {
        		queue.add(node.next);
        	}
        }
        return dummy.next;
    }

}
