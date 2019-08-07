package CodingRush._53_Array_GetNumberOfK;

public class GetNumberOfK {

    private int getFirstK(int[] a, int k, int start, int end) {
        if (a.length == 0 || start > end) { return -1; }

        int middle = start + ((end - start) >> 1);
        if (a[middle] == k) {
            if (middle > 0 && a[middle - 1] != k || middle == 0) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (middle > k) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }

        return getFirstK(a, k, start, end);
    }

    private int getLastK(int[] a, int k, int start, int end) {
        if (a.length == 0 || start > end) { return -1; }

        int middle = start + ((end - start) >> 1);
        if (a[middle] == k) {
            if (middle > 0 && a[middle + 1] != k || middle == a.length - 1) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (middle < k) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }

        return getLastK(a, k, start, end);
    }


    public int getNumberOfK(int[] a, int k) {
        int n = 0;
        if (a.length > 0) {
            int first = getFirstK(a, k, 0, a.length - 1);
            int last  = getLastK(a, k, 0, a.length - 1);

            if (first > -1 && last > -1) {
                n = last - first + 1;
            }
        }
        return n;
    }

    void unitTest1() {
        int n = getNumberOfK(new int[] {1,2,3,3,3,3,4,5}, 3);
        System.out.println(n);
    }

    public static void main(String[] args) {
        GetNumberOfK g = new GetNumberOfK();
        g.unitTest1();
    }
}
