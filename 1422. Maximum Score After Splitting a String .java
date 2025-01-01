class Solution {
    public int maxScore(String s) {
        // Initialize variables to count the number of '0's on the left (l) and '1's on the right (r)
        int l = 0; // Count of '0's in the left substring
        int r = 0; // Count of '1's in the right substring
        int n = s.length(); // Length of the string

        // Check if the first character is '0'. If yes, increment the left count
        if (s.charAt(0) == '0') {
            l = 1;
        }

        // Count all '1's in the string starting from the second character
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                r++;
            }
        }

        // Initialize maxScore with the sum of '0's in the left and '1's in the right
        int maxScore = l + r;

        // Iterate through the string (excluding the last character) to update scores
        for (int i = 1; i < n - 1; i++) {
            // Update counts based on the character at position i
            if (s.charAt(i) == '1') {
                r--; // A '1' moves from the right to the left partition
            } else {
                l++; // A '0' moves from the right to the left partition
            }
            // Update maxScore to the maximum score found so far
            maxScore = Math.max(maxScore, l + r);
        }

        // Return the maximum score found
        return maxScore;
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)
// Approach: Iterative Partitioning Scoring
