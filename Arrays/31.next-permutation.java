
//@lc app=leetcode id=31 lang=java
// Problem: https://leetcode.com/problems/next-permutation/
// Approach: Stepwise transformation to obtain the next lexicographically larger permutation
// Steps:
//   1️⃣ Find the pivot index 'i' where nums[i] < nums[i+1] (first decreasing element from right).
//   2️⃣ If found, locate the element just larger than nums[i] to its right (index 'j').
//   3️⃣ Swap nums[i] and nums[j] to slightly increase the sequence.
//   4️⃣ Reverse the suffix (i+1 → end) to make it the smallest possible order.

// Time Complexity: O(n) — single pass from right to left, plus one reverse.
// Space Complexity: O(1) — in-place modification of the array.

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find first decreasing element from the right
        // (Pivot index where nums[i] < nums[i+1])
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such a pivot exists, find the smallest number
        // larger than nums[i] to the right of it
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap pivot and successor
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix to get the smallest order
        reverse(nums, i + 1, n - 1);
    }

    // Swaps two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverses the elements in arr[start..end]
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
