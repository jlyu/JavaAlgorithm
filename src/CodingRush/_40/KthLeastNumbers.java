package CodingRush._40;

/*
题目：输入n个整数，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8、这8个数字，则最小的4个数字是 1、2、3、4

跟上一题39有点像，同样是初始无序数组，如果已排序则答案不明而喻，但是排序的时间复杂度本身要 O(nlogn) 不考虑
一般来说，这里就要借助其他数据结构了，用来存放最小Kth的数字，
如果 n <= K， 那么数组中的数字全部可以放入
如果 n > K,   当存入第K+1的时候，需要先找出当前数据结构中最大的那个数X，比较X和a[K+1], 如果X大，则把X移除，把当前K+1对应数放入

那么这样的时间复杂度是 O(n * 选择的数据结构在查找，删除，插入全过程的时间复杂度)

Tag： partition, 最大堆，红黑树
*/

import DataStructure.MaxHeapPriorityQueueImpl;
import java.util.ArrayList;

public class KthLeastNumbers {
    public static ArrayList<Integer> solve(int[] a, int k) {

        final int n = a.length;
        if (n < k || k < 1) { return null; }

        MaxHeapPriorityQueueImpl maxHeap = new MaxHeapPriorityQueueImpl(k);

        for (int i = 0; i < n; i++) {
            if(maxHeap.size() < k) {
                maxHeap.offer(a[i]);
            } else {
                // poll the max value from maxHeap，compare to the current value
                // remove current value or maxValue and insert the new value
                if (maxHeap.peek() > a[i]) {
                    maxHeap.poll();
                    maxHeap.offer(a[i]);
                }
            }
        }
        return maxHeap.toArray();
    }

    public static void main(String[] args) {

        System.out.println( new KthLeastNumbers().solve((new int[] {4, 5, 1, 1, 2, 7, 3, 8}), 4).toString() );
    }

}
