package Leetcode._240_M_Search_A_2d_Matrix_II;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.

https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 */
public class SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;

        if (rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                }
                else if (matrix[row][col] > target) {
                    --col;
                } else {
                    ++row;
                }
            }
        }
        return false;
    }
}