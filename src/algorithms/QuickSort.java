package Algorithms;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int[] a, int i, int j) {
        int pivot = a[i];

        while (i < j) {
            while (i < j && a[j] >= pivot) { j--; }
            if(i < j) { a[i] = a[j]; }

            while (i < j && a[i] <= pivot) { i++; }
            if(i < j) { a[j] = a[i]; }

        }

        a[i] = pivot;
        return i;
    }

    static void quickSort(int[] a, int begin, int end) {
        if (begin < end) {
            int p = partition(a, begin, end);
            quickSort(a, begin, p - 1);
            quickSort(a, begin + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {21, 34, 74, 3, 20, 2, 56, 46, 6};
        QuickSort.quickSort(a, 0, 8);

        System.out.println(Arrays.toString(a));

    }
}
