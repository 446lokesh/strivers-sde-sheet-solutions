import java.util.ArrayList;
import java.util.List;

//@lc app=leetcode id=118 lang=java
// Problem: https://leetcode.com/problems/pascals-triangle/
// Approach: Iterative row-by-row using binomial coefficient relation
// Formula: C(n, r+1) = C(n, r) * (n-r) / (r+1)
// Time Complexity: O(numRows^2) → total elements in the triangle
// Space Complexity: O(numRows^2) → storing all rows in result

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(); // Final triangle

        // Generate each row
        for (int n = 0; n < numRows; n++) {
            List<Integer> row = new ArrayList<>();
            int val = 1; // First element of every row is always 1 (nC0 = 1)

            // Build row using relation between consecutive binomial coefficients
            for (int r = 0; r <= n; r++) {
                row.add(val); // Add current value to the row
                // Update val for next element using:
                // C(n, r+1) = C(n, r) * (n-r) / (r+1)
                val = val * (n - r) / (r + 1);
            }

            result.add(row); // Add completed row to triangle
        }

        return result;
    }
}
