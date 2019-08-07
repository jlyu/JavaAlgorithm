package CodingRush._53_Array_GetNumberOfK;

public class GetNumberSameAsIndex {

    public int getNumberSameAsIndex(int[] a) {
        if (a.length == 0) { return -1; }
        int low = 0;
        int high = a.length - 1;



        while (low <= high) {
            int middle = low + ((high - low) >> 1);

            if (middle == a[middle]) { return middle; }

            if (middle > a[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    void unitTest1() {
        System.out.println(getNumberSameAsIndex(new int[] {-3,-2,-1,1,2,5,6,7}));
    }

    public static void main(String[] args) {
        GetNumberSameAsIndex g = new GetNumberSameAsIndex();
        g.unitTest1();
    }
}
