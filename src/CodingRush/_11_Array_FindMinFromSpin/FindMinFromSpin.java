package CodingRush._11_Array_FindMinFromSpin;

public class FindMinFromSpin {

    public int findMinFromSpin(int[] a) {
        if (a.length < 1) {
            try {
                throw new Exception("Invalid Input");
            } catch (Exception e) { e.printStackTrace(); }
        }

        int index1 = 0;
        int index2 = a.length - 1;
        int middle = index1;

        while (a[index1] >= a[index2]) {
            if (index2 - index1 == 1) {
                middle = index2;
                break;
            }

            middle = index1 + ((index2 - index1) >> 1);

            if (a[middle] >= a[index1]) { index1 = middle; }
            else { index2 = middle; }
        }

        return a[middle];
    }

    void unitTest1() {
        System.out.print(findMinFromSpin(new int[] {3,4,5,1,2}));
        System.out.println();
    }

    void unitTest2() {
        System.out.print(findMinFromSpin(new int[] {0,1,1,1,1}));
        System.out.println();
    }

    public static void main(String[] args) {
        FindMinFromSpin f = new FindMinFromSpin();
        f.unitTest1();
        f.unitTest2();
    }
}
