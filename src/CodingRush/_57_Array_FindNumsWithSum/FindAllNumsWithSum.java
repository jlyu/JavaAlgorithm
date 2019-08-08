package CodingRush._57_Array_FindNumsWithSum;

public class FindAllNumsWithSum {
    private void printRangeNums(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i + ((i == big) ? "": ","));
        }
        System.out.println();
    }

    public void findAllNumsWithSum(int sum)  {
        if (sum < 3) { return; }

        int small = 1;
        int big = 2;
        int middle = (1 + sum) >> 1;
        int curSum = small + big;

        while (small < middle) {
            if (curSum == sum) { printRangeNums(small, big); }

            while (curSum > sum && small < middle) {
                curSum -= small;
                small += 1;

                if (curSum == sum) { printRangeNums(small, big); }
            }

            big += 1;
            curSum += big;
        }
    }

    void unitTest1() {
        findAllNumsWithSum(15);
    }

    public static void main(String[] args) {
        FindAllNumsWithSum f = new FindAllNumsWithSum();
        f.unitTest1();
    }
}
