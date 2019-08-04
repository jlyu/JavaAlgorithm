package CodingRush._14_DP_Greedy_CuttingRope;

public class DP_CuttingRope {

    public int cuttingRope(final int n) {
        if (n <= 1) { return 0; }
        if (n == 2) { return 1; }
        if (n == 3) { return 2; }

        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int p = a[j] * a[i-j];
                if (max < p) { max = p; }
                a[i] = max;
            }
        }

        return a[n];
    }

    void unitTest1() {
        System.out.println(cuttingRope(8));
    }

    public static void main(String[] args) {
        DP_CuttingRope dp = new DP_CuttingRope();
        dp.unitTest1();
        System.out.println(8>>1);
    }
}
