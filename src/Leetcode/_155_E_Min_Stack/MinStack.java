package Leetcode._155_E_Min_Stack;

import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl;

import java.util.EmptyStackException;
import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.


https://leetcode-cn.com/problems/min-stack

 */
public class MinStack {

    public class Element {
        int value;
        int minValue;
        Element(int value, int min) {
            this.value = value;
            this.minValue = min;
        }
    }
    Stack<Element> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(new Element(x, x));
        } else {
            stack.push(new Element(x, Math.min(x, stack.peek().minValue)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().minValue;
    }

    ////////////////////////////////////////////

    public void unittest1() {
        push(1);
        push(2);
        top();
        int a = getMin();
        pop();
        int b = getMin();
        top();
    }

    public static void main(String[] args) {
        MinStack a = new MinStack();
        a.unittest1();
    }
}
