package Leetcode._000_;

import java.util.HashSet;
import java.util.Set;

public class IsZeroSubArrayExist {
    public boolean isZeroSubArrayExist_(int[] a) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (set.contains(sum)) {
                return true;
            } else {
                set.add(sum);
            }
        }
        return false;
    }

    private boolean isZero(int[] a, int L, int R) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            sum += a[i];
        }
        return sum == 0;
    }

    public boolean isZeroSubArrayExist(int[] a) {
        int L = 0, R = 0;
        int window = 0;
        while (R < a.length) {
            window += a[R];
            R++;
            while (window != 0) {
                window -= a[L];
                L++;
            }
        }
        return false;
    }


    ///////////////////////////////////////////////////////////////////
    public void unittest1() {
        System.out.println(isZeroSubArrayExist(new int[] {4,2,1,0,6}));
    }

    public static void main(String[] args) {
        IsZeroSubArrayExist a = new IsZeroSubArrayExist();
        a.unittest1();
    }
}
