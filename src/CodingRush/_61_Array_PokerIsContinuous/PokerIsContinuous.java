package CodingRush._61_Array_PokerIsContinuous;

import java.util.Arrays;

public class PokerIsContinuous {
    public boolean isContinuous(int[] a) {
        if (a.length != 5) { return  false; }

        Arrays.sort(a);

        int jokerSize = 0;
        int gapSize = 0;

        for (int i = 0; i < 5; i++) {
            if (a[i] == 0) { jokerSize += 1; }
        }

        for (int i=jokerSize; i < 5-1; i++) {
            if (a[i] == a[i+1]) { return  false; }
            gapSize += a[i+1] - a[i] - 1;
        }

        return (jokerSize >= gapSize);
    }

    void unitTest1() {
        // false
        System.out.println(isContinuous(new int[] {8,0,0,5,3}));
        System.out.println(isContinuous(new int[] {5,0,2,2,0}));
        System.out.println(isContinuous(new int[] {1,0,0,0,9}));

        // true
        System.out.println(isContinuous(new int[] {0,0,0,0,0}));
        System.out.println(isContinuous(new int[] {1,2,5,4,3}));
        System.out.println(isContinuous(new int[] {1,0,5,4,3}));
    }

    public static void main(String[] args) {
        PokerIsContinuous p = new PokerIsContinuous();
        p.unitTest1();
    }
}
