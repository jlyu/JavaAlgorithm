package CodingRush._42_Array_FindGreatestOfSumSubArray;

public class FindGreatestOfSumSubArray {

    public int findGreatestOfSumSubArray(int[] a) {
        final int n = a.length;
        if (n == 0) { return 0; }

        int currentSum = 0;
        int greatestSum = 0x80000000;
        for (int i = 0; i < n; i++) {

            currentSum  = (currentSum <= 0) ? a[i] : currentSum + a[i];
            greatestSum = Math.max(greatestSum, currentSum);
        }

        return greatestSum;
    }

    void unitTest1() {
        int[] a = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestOfSumSubArray(a));
    }

    public static void main(String[] args) {
        FindGreatestOfSumSubArray f = new FindGreatestOfSumSubArray();
        f.unitTest1();
    }
}
