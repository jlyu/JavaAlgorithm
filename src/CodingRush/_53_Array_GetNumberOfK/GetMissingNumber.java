package CodingRush._53_Array_GetNumberOfK;

public class GetMissingNumber {
    public int getMissingNumber(int[] a) {
        if (a.length == 0) { return -1; }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (middle != a[middle]) {
                if (middle == 0 || a[middle - 1] == middle - 1) {
                    return middle;
                }
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        if (low == a.length) { return a.length; }
        return -1;
    }

    void unitTest1() {
        System.out.println(getMissingNumber(new int[] {0,1,2,3,4,4,6}));
    }

    public static void main(String[] args) {
        GetMissingNumber g = new GetMissingNumber();
        g.unitTest1();
    }
}
