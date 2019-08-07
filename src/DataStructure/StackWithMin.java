package DataStructure;

import java.util.Stack;

public class StackWithMin {

    Stack<Integer> data;
    Stack<Integer> mins;

    StackWithMin() {
        data = new Stack<>();
        mins = new Stack<>();
    }

    public void push(final int v) {
        data.push(v);
        if (mins.empty() || v < mins.peek()) {
            mins.push(v);
        } else {
            mins.push(mins.peek());
        }
    }

    public void pop() {
        if (data.empty() || mins.empty()) {
            throw new IndexOutOfBoundsException();
        }
        data.pop();
        mins.pop();
    }

    public Integer min() {
        if (data.empty() || mins.empty()) {
            throw new IndexOutOfBoundsException();
        }
        return mins.peek();
    }

    public void unitTest() {
        StackWithMin sm = new StackWithMin();
        sm.push(3); System.out.print(sm.min() + ", ");
        sm.push(4); System.out.print(sm.min() + ", ");
        sm.push(2); System.out.print(sm.min() + ", ");
        sm.push(1); System.out.print(sm.min() + ", ");
        sm.pop();      System.out.print(sm.min() + ", ");
        sm.pop();      System.out.print(sm.min() + ", ");
        sm.push(0); System.out.print(sm.min() + ", ");
    }

    public static void main(String[] args) {
        StackWithMin sm = new StackWithMin();
        sm.unitTest();
    }

}
