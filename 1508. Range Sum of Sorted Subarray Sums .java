import java.util.Arrays;

class Solution {
    /**
     * This method calculates the sum of subarray sums within a specified range.
     */
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Array to store all subarray sums.
        int[] sumArray = new int[(n * (n + 1) / 2)];
        int count = 0;

        // Calculate all subarray sums and store them in the sumArray.
        for (int i = 0; i < n; i++) {
            int tempSum = 0;
            for (int j = i; j < n; j++) {
                tempSum += nums[j];
                sumArray[count] = tempSum;
                count++;
            }
        }

        // Sort the array of subarray sums.
        Arrays.sort(sumArray);
        int sum = 0;
        int mod = (int) 1e9 + 7;

        // Calculate the sum of the subarray sums within the range [left, right].
        for (int i = left - 1; i < right; i++) {
            sum = (sum + sumArray[i]) % mod;
        }
        return sum;  // Return the final sum.
    }
}

// Algorithm/Approach: Brute Force and Sorting
//
// Time Complexity: O(n^2 log n)
// - Calculating all subarray sums takes O(n^2) time.
// - Sorting the subarray sums takes O(k log k) time, where k is the number of subarray sums, which is n(n + 1) / 2.
// - Since k = O(n^2), the sorting step takes O(n^2 log n^2) = O(n^2 log n) time.
// - Therefore, the overall time complexity is O(n^2 log n).
//
// Space Complexity: O(n^2)
// - The space complexity is O(k), where k is the number of subarray sums, which is n(n + 1) / 2.
// - This is due to storing all subarray sums in the sumArray.
