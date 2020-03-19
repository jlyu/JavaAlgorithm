package Algorithms;

import java.util.Arrays;

public class BinarySearch {

    public int binarySearch(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) { return mid; }
            if (a[mid] > target) { high = mid - 1; }
            else { low = mid + 1; }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] a = {21, 34, 74, 3, 20, 2, 56, 18, 6};
        Arrays.sort(a);

        BinarySearch b = new BinarySearch();

        System.out.println(b.binarySearch(a, 18));
    }
}
