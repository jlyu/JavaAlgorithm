package CodingRush._06_List_PrintListReversingly;

import DataStructure.MyList;
import java.util.Stack;

public class PrintListReversingly {

    private MyList list;

    PrintListReversingly() {}

    PrintListReversingly(MyList list) {
        this.list = list;
    }

    private void printListReverse(MyList.ListNode head) {
        if (head != null) {
            if (head.next != null) {
                printListReverse(head.next);
            }

            System.out.print("->" + head.value);
        }
    }

    private void printListWithStack(MyList.ListNode head) {
        MyList.ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + "->");
        }
        System.out.print("null.");
    }


    public void solve() {
        MyList.ListNode head = list.getHead();
        printListReverse(head);
        System.out.println();
        printListWithStack(head);
    }


    // Unit Tests
    public void unitTest1() {
        int[] a = {1,2,3,4,5,6,7,8,9};
        MyList list = new MyList(a);
        PrintListReversingly printListReversingly = new PrintListReversingly(list);
        printListReversingly.solve();
        System.out.println();
    }

    public void unitTest2() {
        int[] a = {4};
        MyList list = new MyList(a);
        PrintListReversingly printListReversingly = new PrintListReversingly(list);
        printListReversingly.solve();
        System.out.println();
    }

    public void unitTest3() {
        int[] a = { };
        MyList list = new MyList(a);
        PrintListReversingly printListReversingly = new PrintListReversingly(list);
        printListReversingly.solve();
        System.out.println();
    }


    public static void main(String[] args) {
        PrintListReversingly p = new PrintListReversingly();
        p.unitTest1();
        p.unitTest2();
        p.unitTest3();
    }
}
