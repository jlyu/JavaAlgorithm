package DataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinHeapPriorityQueueImpl {
    private PriorityQueue<Integer> minHeap;
    private int size;

    public MinHeapPriorityQueueImpl(int size) {
        this.size = size;
        this.minHeap = new PriorityQueue<Integer>(size, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public int size() { return minHeap.size(); }

    public void offer(int ele) {
        minHeap.offer(ele);
    }

    public Integer poll() { return minHeap.poll(); }

    public Integer peek() { return minHeap.peek(); }

    public ArrayList<Integer> toArray() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer integer : minHeap) {
            result.add(integer);
        }
        return result;
    }
}
