// Problem: https://leetcode.com/problems/set-matrix-zeroes/
// Approach: Use first row & column as markers to track zero positions
// Time Complexity: O(m * n)
// Space Complexity: O(1)

class Solution {
    public void setZeroes(int[][] matrix) {

        boolean frow = false, fcol = false; // flags for first row & first column

        // Step 1: Traverse the matrix and use first row/col as markers
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) frow = true; // first row needs zeroing
                    if (j == 0) fcol = true; // first column needs zeroing
                    matrix[i][0] = 0;        // mark row i
                    matrix[0][j] = 0;        // mark col j
                }
            }
        }

        // Step 2: Update the inner matrix using markers (exclude first row & col)
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0; // set cell to zero if row/col is marked
                }
            }
        }

        // Step 3: Handle the first row if it needs to be zeroed
        if (frow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Handle the first column if it needs to be zeroed
        if (fcol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
