/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code
// Problem: https://leetcode.com/problems/maximum-subarray/
// Approach: Kadane’s Algorithm (Dynamic Programming)
// Idea: Track the maximum subarray sum ending at each index using a running sum
//       If running sum < 0, reset it — as it can’t contribute to a larger sum
// Time Complexity: O(n) → Single traversal through the array
// Space Complexity: O(1) → Constant extra space

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Stores the maximum sum found so far
        int currSum = 0;                // Running sum for current subarray

        for (int num : nums) {
            currSum += num;                      // Extend current subarray
            maxSum = Math.max(maxSum, currSum);  // Update global max
            if (currSum < 0) currSum = 0;        // Reset if sum becomes negative
        }

        return maxSum; // Return maximum subarray sum
    }
}
// @lc code=end

