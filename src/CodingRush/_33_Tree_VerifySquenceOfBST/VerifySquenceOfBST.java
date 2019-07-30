package CodingRush._33_Tree_VerifySquenceOfBST;

import java.util.Arrays;

public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] a, int n) {
        if (n < 1) { return false; }

        int rootValue = a[n-1];

        int i = 0;
        for (; i < n-1; i++) {
            if (rootValue < a[i]) {
                break;
            }
        }

        int j = i;
        for (; j < n - 1; j++) {
            if (rootValue > a[j]) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            left = verifySquenceOfBST(Arrays.copyOfRange(a, 0, i), i);
        }

        boolean right = true;
        if (i < n - 1) {
            right = verifySquenceOfBST(Arrays.copyOfRange(a, i + 1, n), n - i - 1);
        }

        return (left && right);
    }

    void unitTest1() {
        int[] a = {5,7,6,9,11,10,8};
        boolean result = verifySquenceOfBST(a, a.length);
        System.out.println(result);
    }

    void unitTest2() {
        int[] a = {7,4,6,5};
        boolean result = verifySquenceOfBST(a, a.length);
        System.out.println(result);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST v = new VerifySquenceOfBST();
        v.unitTest1();
        v.unitTest2();
    }
}
