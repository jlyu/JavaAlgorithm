package CodingRush._39_Array_MoreThanHalfNumber;

/*
题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如，输入一个长度为9的数组{1,2,3,2,2,2,5,4,2} 。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出 2.

数组本身是无序的。如果要做排序的话，时间复杂度会上升到 O(n·logn)
那么这里肯定就不先考虑排序了，想想看如何通过一次遍历就拿到结果 O(n)

直觉就是弄一个散列表，数字作为key，出现次数作为value，再额外记录一下maxValue
这样遍历一遍下来就能拿到那个数了。

然后考虑一下是否能够不借助额外的数据结构（减少空间开销）
还是要从题目出发，要找的这个数字的出现次数占了整个数组长度的一半还要多，
亦即，其他数字的个数加起来都没这个数多。

用一个计数器记录当前数字出现的累计次数，
如果数字相同，则+1，
如果数字不同，则-1，
当计数器归零，则重新记录当前数字和计数器

注意输入数组的边界值。

Tag： partition,
 */


import Algorithms.QuickSort;

public class MoreThanHalfNumber {
    private int result = 0;
    private int counter = 0;

    public int solve(int[] a) {
        final int n = a.length;
        if (n < 1) { return 0; }

        result = a[0];
        counter = 1;

        for (int i = 1; i < n; i++) {

            if (counter == 0) {
                result = a[i];
                counter = 1;
            }

            if (a[i] == result) {
                counter++;
            } else {
                counter--;
            }

        }
        return result;
    }

    public int solve2(int[] a) {
        final int n = a.length;
        int middle = n >> 1;
        int begin = 0;
        int end = n - 1;
        int pivot = QuickSort.partition(a, begin, end);
        while (pivot != middle) {
            if (pivot > middle) {
                end = pivot - 1;
            }

            else {
                begin = pivot + 1;
            }
            pivot = QuickSort.partition(a, begin, end);
        }

        //TODO: validation
        return a[middle];
    }


    public static void main(String[] args) {
        MoreThanHalfNumber ins = new MoreThanHalfNumber();

        int[] test1 = {1,2,3,4,4,4,4};
        System.out.println(ins.solve(test1));

        int[] test2 = {1,2,3,2,2,2,5,4,2};
        System.out.println(ins.solve2(test2));
    }
}