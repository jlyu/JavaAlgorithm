package CodingRush._12_Array_hasPath;

public class HasPath {
    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                char[] str, int pathLength, boolean[] isVisited) {

        if (str.length == pathLength) { return true; }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                matrix[row * cols + col] == str[pathLength] && !isVisited[row * cols + col]) {

            pathLength += 1;
            isVisited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, isVisited) ||
                      hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, isVisited) ||
                      hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, isVisited) ||
                      hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, isVisited);

            if (!hasPath) {
                isVisited[row * cols + col] = false;
                pathLength -= 1;
            }
        }
        return hasPath;

    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // Validation
        if (matrix == null || str == null || str.length < 1 || matrix.length < str.length || matrix.length < 1) {
            return false;
        }

        // Helper
        boolean[] isVisited = new boolean[rows * cols];

        // Core
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    void unitTest1() {
        char[] matrix = new char[]{'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = new char[]{'A','B','C','C','E','D'};
        System.out.println(hasPath(matrix,3,4, str));
    }

    public static void main(String[] args) {
        HasPath h = new HasPath();
        h.unitTest1();
    }
}


