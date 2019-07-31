package CodingRush._03_Array_ValueRepeat;

public class ArrayValueRepeat {

    public int findRepeatValue(int[] a) {
        final int n = a.length;
        if (n <= 0) { return -1;}

        for (int i = 0; i < n; i++) {
            if (a[i] < 0 || a[i] > n - 1) { return -1; }
        }

        for (int i = 0; i < n; i++) {

            while (i != a[i]) {

                if (a[a[i]] == a[i]) { return a[i]; }
                else {
                    int temp = a[a[i]];
                    a[a[i]] = a[i];
                    a[i] = temp;
                }
            }
        }
        return -1;
    }

    public void unitTest1() {
        int[] a = {5,2,3,1,0,2,5,3,4};
        System.out.println(findRepeatValue(a));
    }

    public static void main(String[] args) {
        ArrayValueRepeat a = new ArrayValueRepeat();
        a.unitTest1();
    }
}
