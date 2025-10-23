/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 * Approach: Track minimum price encountered so far and calculate maximum profit
 * by finding the difference between current price and minimum price.
 * Steps:
 *    1️⃣ Initialize minPrice to maximum value and maxProfit to 0
 *    2️⃣ Iterate through each price in the array
 *    3️⃣ If current price is lower than minPrice, update minPrice
 *    4️⃣ Otherwise, calculate profit (current price - minPrice) and update maxProfit if higher
 *    5️⃣ Return the maximum profit found
 *
 * Time Complexity: O(n) — Single pass through the prices array
 * Space Complexity: O(1) — Only using constant extra space
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
// @lc code=end
