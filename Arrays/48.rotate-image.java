//@lc app=leetcode id=48 lang=java
// Problem: https://leetcode.com/problems/rotate-image/
// Approach: 1) Transpose the matrix (swap symmetric elements across diagonal)
//           2) Reverse each row
// Time Complexity: O(n²)
// Space Complexity: O(1) — in-place rotation

class Solution {
    public void rotate(int[][] matrix) {

        // Step 1: Transpose matrix (convert rows → columns)
        transpose(matrix);

        // Step 2: Reverse each row to get 90° clockwise rotation
        reverse(matrix);
    }

    // Transpose matrix by swapping (i, j) with (j, i)
    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {  
                swap(i, j, matrix);
            }
        }
    }

    // Swap elements for transpose step
    private void swap(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    // Reverse each row
    private void reverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            int left = 0;
            int right = matrix[i].length - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
// @lc code=end
