package CodingRush._13_Array_MovingCount;

public class MovingCount {
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private boolean check (int rows, int cols, int row, int col, int k, boolean[] isVisited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !isVisited[row * cols + col]) {
            if (getDigitSum(row) + getDigitSum(col) <= k ) {
                return true;
            }
        }
        return false;
    }

    private int movingCountCore(int rows, int cols, int row, int col, int k, boolean[] isVisited) {
        int count = 0;
        if (check(rows, cols, row, col, k, isVisited)) {
            isVisited[row * cols + col] = true;

            count = 1 + movingCountCore(rows, cols, row - 1, col, k, isVisited) +
                        movingCountCore(rows, cols, row + 1, col, k, isVisited) +
                        movingCountCore(rows, cols, row, col - 1, k, isVisited) +
                        movingCountCore(rows, cols, row, col + 1, k, isVisited);
        }
        return count;
    }


    public int movingCount(int rows, int cols, int k) {
        if (rows < 0 || cols < 0 || k < 0) { return 0;}

        boolean[] isVisited = new boolean[rows * cols];

        return movingCountCore(rows, cols, 0 , 0, k, isVisited);
    }

    void unitTest1() {
        System.out.println( movingCount(10,10, 1) );
    }

    public static void main(String[] args) {
        MovingCount m = new MovingCount();
        m.unitTest1();
    }
}
