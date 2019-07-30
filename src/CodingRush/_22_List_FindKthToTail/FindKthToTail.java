package CodingRush._22_List_FindKthToTail;

import DataStructure.MyList;

public class FindKthToTail {



    public MyList.ListNode findKthToTail(MyList.ListNode head, int k) {
        if (k <= 0) { return null; }
        if (head == null) { return null; }

        MyList.ListNode first = head;
        MyList.ListNode second = head;

        for (int i = 0; i < k; i++) {
            first = first.next;
            if (first == null) {
                return null;
            }
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println("Find Kth Node to Tail: " + second.value);
        return second;
    }


    public void unitTest1() {
        int a[] = {1,2,3,4,5,6};
        int k = 3;
        MyList list = new MyList(a);
        findKthToTail(list.getHead(), k);
        System.out.println();
    }

    public void unitTest2() {
        int a[] = {1,2,3,4,5,6};
        int k = 0;
        MyList list = new MyList(a);
        findKthToTail(list.getHead(), k);
        System.out.println();
    }

    public void unitTest3() {
        int a[] = {1,2,3,4,5,6};
        int k = 8;
        MyList list = new MyList(a);
        findKthToTail(list.getHead(), k);
        System.out.println();
    }

    public void unitTest4() {
        int a[] = {1,2,3,4,5,6};
        int k = 1;
        MyList list = new MyList(a);
        findKthToTail(list.getHead(), k);
        System.out.println();
    }

    public void unitTest5() {
        int a[] = {1,2,3,4,5,6};
        int k = 1;
        MyList list = new MyList(a);
        findKthToTail(null, k);
        System.out.println();
    }

    public static void main(String[] args) {
        FindKthToTail f = new FindKthToTail();
        f.unitTest1();
        f.unitTest2();
        f.unitTest3();
        f.unitTest4();
        f.unitTest5();
    }
}
