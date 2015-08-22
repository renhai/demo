package com.sankuai.meituan.test.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode tmp = head;
		for (int i = 2; i <= 10 ; i++) {
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		
		ListNode result = new Solution().reverseList(head);
		printListNode(result);
		
		int[] arr = new int[] {0,1,2,4,5,7};
		List<String> list = new Solution().summaryRanges(arr);
		System.out.println(list);
		
		System.out.println(new Solution().toNumber("aab"));
		
		System.out.println();
		
	}
	
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
	
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
    }
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(true) {
			if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				return root;
			}
		}
    }
	
    public void deleteNode(ListNode node) {
    	if (node.next == null) {
			return;
		}
    	ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next = null;
    }
    
    public boolean isPalindrome(ListNode head) {
    	if (head == null ) {
			return false;
		}

    	ListNode tmp = head;
    	Stack<Integer> stack = new Stack<Integer>();
    	while (tmp != null) {
			stack.push(tmp.val);
			tmp = tmp.next;
		}
    	
    	while (head != null) {
    		if (head.val == stack.pop().intValue()) {
				head = head.next;
			} else {
				return false;
			}
    	}
    	return true;
        
    }
    
    public ListNode reverseList(ListNode head) {
    	/** 利用栈的方式
    	if (head == null) {
			return head;
		}
    	Stack<Integer> stack = new Stack<Integer>();
    	while (head != null) {
    		stack.push(head.val);
    		head = head.next;
    	}
    	ListNode newHead = new ListNode(stack.pop());
    	ListNode curr = newHead;
    	while (!stack.isEmpty()) {
    		curr.next = new ListNode(stack.pop());
    		curr = curr.next;
    	}
        return newHead;
        */
    	
    	ListNode newHead = null;
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = newHead;
    		newHead = head;
    		head = next;
    	}
    	
    	return newHead;
    }
    
    //For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
    //TODO
    public List<String> summaryRanges(int[] nums) {
    	List<String> result = new ArrayList<String>();

        return result;
    }
    
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
    	return false;
    }
    
    public boolean isIsomorphic(String s, String t) {
    	if (s == null || t == null) {
    		return false;
    	}
    	if (s.length() != t.length()) {
			return false;
		}
    	
    	return toNumber(s).equals(toNumber(t));
        
    }
    
    public String toNumber(String str) {
    	StringBuilder sb = new StringBuilder();
    	char[] arr = str.toCharArray();
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	int index = 0;
    	for (int i = 0; i < arr.length; i++) {
			if (!map.keySet().contains(arr[i])) {
				sb.append(index);
				map.put(arr[i], index);
				index ++;
			} else {
				sb.append(map.get(arr[i]));
			}
		}
    	return sb.toString();
    }
    
    
//    Example
//    Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//    Return: 1 --> 2 --> 3 --> 4 --> 5
    public ListNode removeElements(ListNode head, int val) {
    	while (head != null && head.val == val) {
    		head = head.next;
    	}
    	ListNode curr = head;
    	while (curr != null && curr.next != null) {
    		if (curr.next.val == val) {
    			curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
    	}
        return head;
    }
    
    public void rotate(int[] nums, int k) {
    	int len = nums.length;
    	if (k % len == 0) {
    		return;
    	}
    	k = k % len;
    	reverse(nums, 0, len - 1);
    	reverse(nums, 0, k - 1);
    	reverse(nums, k, len - 1);
    }
    
    public void reverse(int[] arr, int from, int end) {
    	while (from < end) {
    		int tmp = arr[from];
    		arr[from] = arr[end];
    		arr[end] = tmp;
    		from ++;
    		end --;
    	}
    }
    
    public int trailingZeroes(int n) {
        int fa = factorial(n);
        int count = 0;
        while (fa % 10 == 0) {
        	count ++;
        	fa = fa % 10; 
        }
        return count;
    }
    
    public int factorial(int n) {
    	if (n <= 1) {
    		return n;
    	}
    	return n * factorial(n - 1);
    }
    
    public static void printListNode(ListNode head) {
    	ListNode tmp = head;
    	while (tmp != null) {
    		System.out.print(tmp.val + "\t");
    		tmp = tmp.next;
		}
    	System.out.println();
    }

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
