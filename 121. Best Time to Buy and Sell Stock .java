class Solution {
    public int maxProfit(int[] prices) {
        // Initialize the maximum profit to 0
        int profit = 0;
        
        // Initialize two pointers l (left) and r (right) to the start of the array
        int l = 0, r = 0;
        
        // Iterate through the prices array
        while (r < prices.length) {
            // If the current price at r is less than the price at l, move l to r
            if (prices[r] < prices[l]) {
                l = r;
            } else {
                // Calculate the potential profit and update the maximum profit if needed
                profit = Math.max(profit, prices[r] - prices[l]);
            }
            // Move the right pointer to the next day
            r++;
        }
        
        // Return the maximum profit found
        return profit;
    }
}

// Time Complexity
// O(n)
// Space Complexity
// O(1).
// Algorithm Approach
// Two Pointers approach
