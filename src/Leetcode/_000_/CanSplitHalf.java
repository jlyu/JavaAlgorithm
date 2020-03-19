package Leetcode._000_;

public class CanSplitHalf {
    public int canSplit(int[] a) {

        int sum = 0;
        for (int i = 0; i < a.length; i++) { sum += a[i]; }

        int curSum = 0;

        for (int i = 0; i < a.length; i++) {
            if (sum - a[i] == curSum * 2) {
                return i;
            }
            curSum += a[i];

        }
        return -1;
    }

    public int findSplitIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        } // sum = 16
        int crrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (crrSum * 2  == (sum - arr[i])) {  //index:0 -> 0 !=  8 - 1
                return i;  //3                    //index:1 -> 1 !=  8 - 2
            }                                    //index:2 -> 3 != (16 - 3) / 2
            crrSum += arr[i];                     //index:3 -> 6 == (16 - 4) / 2
        }
        return -1;
    }


    public void unittest1() {
        System.out.println(canSplit(new int[] {1,7,3,6,5,6}));
    }

    public static void main(String[] args) {
        CanSplitHalf a = new CanSplitHalf();
        a.unittest1();
    }
}
