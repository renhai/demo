package me.renhai.oj;

import java.util.Stack;

public class Stack2Queue<T> {
	
	private Stack<T> newStack;
	private Stack<T> oldStack;
	
	public Stack2Queue() {
		newStack = new Stack<T>();
		oldStack = new Stack<T>();
	}

	public void add(T value) {
		newStack.push(value);
	}
	
	public T remove() {
		if (oldStack.isEmpty()) {
			while (!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		} 
		if (oldStack.isEmpty()) {
			return null;
		} else {
			return oldStack.pop();
		}
	}

	public static void main(String[] args) {
		Stack2Queue<Integer> queue = new Stack2Queue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		queue.add(4);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		queue.add(5);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
}
