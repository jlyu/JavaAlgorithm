package Algorithms;

public class Partition {

    static private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[j] = a[i];
        a[i] = temp;
    }

    static int partition(int[] a, int begin, int end) {
        int pivot = a[begin];
        swap(a, begin, end);

        int i = begin, j = end;

        while (i < j) {
            while (i < j && a[i] < pivot) { i++; }
            while (i < j && a[j] > pivot) { j--; }
            if (i < j) { swap(a, i, j); }
        }

        swap(a, i, j);
        return i;
    }
}
