package CodingRush._44_Array_PrintMinNumber;


import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {

    public void printMinNumber(int[] a) {
        final int n = a.length;
        if (n == 0) { return; }

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = Integer.toString(a[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String combine1 = s1 + s2;
                String combine2 = s2 + s1;
                return combine1.compareTo(combine2);
            }
        });

        for (String str: strs) {
            System.out.print(str);
        }
    }

    void unitTest1() {
        printMinNumber(new int[] {3,32,321});
    }

    public static void main(String[] args) {
        PrintMinNumber p = new PrintMinNumber();
        p.unitTest1();
    }
}
