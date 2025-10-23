/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 * Approach: Three-pointer partitioning of array into 0s, 1s, and 2s, 
 * sorting in one pass with swaps
 * Steps:
 *    1️⃣ Initialize three pointers: low, mid, high
 *    2️⃣ Traverse array with mid pointer until it passes high
 *    3️⃣ If nums[mid] == 0, swap with nums[low], increment low and mid
 *    4️⃣ If nums[mid] == 1, just increment mid
 *    5️⃣ If nums[mid] == 2, swap with nums[high], decrement high, do not increment mid yet
 * 
 * Time Complexity: O(n) — Single pass through the array
 * Space Complexity: O(1) — In-place sorting
 */

 // @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swapElements(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swapElements(nums, mid, high);
                high--;
            }
        }
    }

    private void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
// @lc code=end
