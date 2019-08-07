package CodingRush._56_Array_FindNumsAppearOnce;

public class FindNumsAppearOnce {

    private boolean isBit1(int n, int bitIndex) {
        n = n >> bitIndex;
        return (n & 1) != 0;
    }

    private int findFirstBit(int n) {
        int bitIndex = 0;
        while ((n & 1) == 0 && (bitIndex < 8 * Integer.SIZE)) {
            n = n >> 1;
            bitIndex += 1;
        }
        return bitIndex;
    }

    public int[] findNumsAppearOnce(int[] a) {
        int[] aOnce = new int[2];
        if (a.length < 2) { return aOnce; }

        int xorResult = 0;
        for (int i = 0; i < a.length; i++) { xorResult ^= a[i]; }

        int bitIndex = findFirstBit(xorResult);
        for (int i = 0; i < a.length; i++) {
            if ( isBit1(a[i], bitIndex) ) {
                aOnce[0] ^= a[i];
            } else {
                aOnce[1] ^= a[i];

            }
        }
        return aOnce;
    }

    void unitTest1() {
        int[] result = findNumsAppearOnce(new int[] {2,4,3,6,3,2,5,5});
        System.out.print(result[0] + " and " + result[1]);
    }

    public static void main(String[] args) {
        FindNumsAppearOnce f = new FindNumsAppearOnce();
        f.unitTest1();
    }
}
