package CodingRush._04_Array2D_FindFromArray2D;

public class FindFromArray2D {
    public boolean canFound(int[][] a, int target) {
        final int rows = a.length;
        if (rows <= 0) { return false; }

        final int cols = a[0].length;
        if (cols <= 0) { return false; }


        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (a[row][col] ==  target) { return true; }

            if (a[row][col] > target)     { col -= 1; }
            else /*a[row][col] < target*/ { row += 1; }
        }

        return false;
    }

    void unitTest1() {
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.println("True:");
        int[] trueCases = {1,2,4,6,7,8,9,10,11,12,13,15};
        for (int trueCase:trueCases) {
            System.out.println(trueCase + " => " + canFound(a, trueCase) );
        }
        System.out.println("False:");
        int[] falseCases = {-1,0,3,14,16};
        for (int falseCase:falseCases) {
            System.out.println(falseCase + " => " + canFound(a, falseCase) );
        }

    }

    public static void main(String[] args) {
        FindFromArray2D f = new FindFromArray2D();
        f.unitTest1();
    }
}
