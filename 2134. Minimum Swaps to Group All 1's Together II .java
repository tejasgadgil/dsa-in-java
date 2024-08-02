class Solution {
    /*
     * This method calculates the minimum number of swaps required to group all 1's in a circular array.
     */
    public int minSwaps(int[] nums) {
        int zeroes = 0;         // Count of zeroes in the current window.
        int n = nums.length;    
        int minswaps = n + 1;   // Initialize minswaps with a large value.
        int window = 0;         

        // Count the number of 1's in the array to determine the window size.
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                window++;
            }
        }

        int i = 0;              // Start index of the window.
        int j = 0;              // End index of the window.

        // Initialize the zeroes count for the first window.
        for (j = 0; j < window; j++) {
            if (nums[j] == 0) {
                zeroes++;
            }
        }

        // Update minswaps for the initial window.
        minswaps = Math.min(minswaps, zeroes);

        // Slide the window across the circular array.
        while (i < n) {
            j = ((i + window) % n) - 1;  // Calculate the new end index of the window. --> since it is a circular array

            // Increment zeroes count if the new element is 0.
            if (nums[j + 1] == 0) {
                zeroes++;
            }

            // Decrement zeroes count if the outgoing element is 0.
            if (nums[i] == 0) {
                zeroes--;
            }

            i++;
            j++;

            // Update minswaps with the minimum zeroes count in the current window.
            minswaps = Math.min(minswaps, zeroes);
        }

        return minswaps;  // Return the minimum number of swaps required.
    }
}

/**
 * Algorithm/Approach: Sliding Window with Circular Array Handling
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 */
