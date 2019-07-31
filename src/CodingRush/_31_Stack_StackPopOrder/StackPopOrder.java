package CodingRush._31_Stack_StackPopOrder;

import java.util.Stack;

public class StackPopOrder {

    public boolean isPopOrder(int[] push, int[] pops) {
        Stack<Integer> stack = new Stack<>();

        final int pushSize = push.length;
        final int popsSize = pops.length;
        if (pushSize != popsSize) { return false; }

        int popsIndex = 0;
        for (int i=0; i<pushSize; i++) {
            stack.push(push[i]);

            while(!stack.empty() && stack.peek() == pops[popsIndex]) {
                stack.pop();
                popsIndex += 1;
            }
        }

        return stack.empty();
    }

    void unitTest1() {
        int[] push = {1,2,3,4,5};
        int[] pops = {4,5,3,2,1};
        boolean result = isPopOrder(push, pops);
        System.out.println(result);
    }

    void unitTest2() {
        int[] push = {1,2,3,4,5};
        int[] pops = {1,2,3,4,5};
        boolean result = isPopOrder(push, pops);
        System.out.println(result);
    }

    public static void main(String[] args) {
        StackPopOrder s = new StackPopOrder();
        s.unitTest1();
        s.unitTest2();
    }
}
