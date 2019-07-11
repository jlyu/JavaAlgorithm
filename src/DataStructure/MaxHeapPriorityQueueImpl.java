package DataStructure;

/*

Algorithm   Average	    Worst case
Insert		O(log n)	O(log n)
Delete		O(log n)    O(log n)

a min-max heap is a complete binary tree data structure which combines the usefulness of both a min-heap and a max-heap,
that is, it provides constant time retrieval and logarithmic time removal of both the minimum and maximum elements in it

堆有最大堆和最小堆之分，最大堆就是每个节点的值都>=其左右子（如果有的话）值的完全二叉树。最小堆便是每个节点的值都<=其左右子值的完全二叉树。

This makes the min-max heap a very useful data structure to implement a double-ended priority queue.
Like binary min-heaps and max-heaps, min-max heaps support logarithmic insertion and deletion and can be built in linear time.


https://www.jianshu.com/p/257820688bf1
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeapPriorityQueueImpl {

    private PriorityQueue<Integer> maxHeap;
    private int size;

    public MaxHeapPriorityQueueImpl(int size) {
        this.size = size;
        this.maxHeap = new PriorityQueue<Integer>(size, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public int size() { return maxHeap.size(); }

    public void offer(int ele) {
        maxHeap.offer(ele);
    }

    public Integer poll() { return maxHeap.poll(); }

    public Integer peek() { return maxHeap.peek(); }

    public ArrayList<Integer> toArray() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
