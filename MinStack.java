/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
package com.leetcode.minstack;

import java.util.Stack;

/**
 * @author aahu
 * 
 */
public class MinStack {

	Stack stack = new Stack<>();
	Stack minStack = new Stack<>();
	

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= (int) minStack.peek()) {
			minStack.push(x);
					
		}
	}

	public void pop() {
		if (minStack.isEmpty() || stack.isEmpty()) {
			return;
		}
		if ((int) (stack.peek()) == (int) (minStack.peek())) {
			minStack.pop();
		}
		stack.pop();
	}

	public int top() {
		return (int) stack.peek();
	}

	public int getMin() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return (int) minStack.peek();
	}

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(2);
		ms.push(0);
		ms.push(3);
		ms.push(0);
		
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		
	}
}
