package CodingRush._23_List_FindEntryNodeOfLoop;

import DataStructure.MyList;

public class FindEntryNodeOfLoop {

    public MyList.ListNode findEntryNode(MyList.ListNode head) {
        if (head == null) { return null; }
        // 1. 判断是否有环
        boolean bHasLoop = false;
        MyList.ListNode doubleNode = head;
        MyList.ListNode singleNode = head;
        while (doubleNode.next != null || doubleNode.next.next != null) {
            doubleNode = doubleNode.next.next;
            singleNode = singleNode.next;
            if (doubleNode == singleNode) {
                bHasLoop = true;
            }
        }
        if (!bHasLoop) { return null;}

        // 2. 找出环的个数
        int loopNodeNum = 1;
        MyList.ListNode node = singleNode;
        while (node.next != singleNode) {
            node = node.next;
            loopNodeNum += 1;
        }

        // 3. 找出环的入口
        MyList.ListNode firstNode = head;
        MyList.ListNode secondNode = head;
        for (int i = 0; i < loopNodeNum; i++) {
            firstNode = firstNode.next;
        }
        while (firstNode != secondNode) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return firstNode;
    }


    public void unitTest1() {}

    public static void main(String[] args) {
        FindEntryNodeOfLoop f = new FindEntryNodeOfLoop();
        f.unitTest1();
    }
}
