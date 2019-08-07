package CodingRush._57_Array_FindNumsWithSum;

public class FindNumsWithSum {

    public int[] findNumsWithSum(int[] a, int sum) throws Exception {
        int[] pair = new int[2];
        if (a.length < 2) { throw new Exception("Invalid Input"); }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int s = a[low] + a[high];
            if (s == sum) { return new int[] { a[low], a[high] }; }

            if (s > sum) {
                high -= 1;

            } else  {
                low += 1;
            }
        }
        return pair;
    }


    void unitTest1()  {
        int[] p = new int[0];
        try {
            p = findNumsWithSum(new int[] {1,2,4,7,11,15}, 15);
            System.out.println(p[0] + " and " + p[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FindNumsWithSum f = new FindNumsWithSum();
        f.unitTest1();

    }
}
