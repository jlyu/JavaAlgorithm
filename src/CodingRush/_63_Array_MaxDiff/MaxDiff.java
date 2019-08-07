package CodingRush._63_Array_MaxDiff;

public class MaxDiff {

    public int maxDiff(int[] a) {
        if (a.length < 2) { return -1; }

        int minPrev = 0x7fffffff;
        int maxDiff = 0x80000000;

        for (int i = 0; i < a.length; i++) {
            minPrev = (a[i] < minPrev) ? a[i] : minPrev;
            maxDiff = ((a[i] - minPrev) > maxDiff) ? (a[i] - minPrev) : maxDiff;
        }

        return maxDiff;
    }

    void unitTest1() {
        System.out.println(maxDiff(new int[] {9,11,8,5,7,12,16,14}));
    }

    public static void main(String[] args) {
        MaxDiff m = new MaxDiff();
        m.unitTest1();
    }
}
