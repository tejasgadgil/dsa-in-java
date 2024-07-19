import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();  // List to store lucky numbers
        HashSet<Integer> maxCol = new HashSet<>();  // Set to store the maximum elements of each column

        // Step 1: Find the maximum elements in each column and add them to maxCol
        for (int j = 0; j < matrix[0].length; j++) {
            int maxm = matrix[0][j];
            for (int i = 0; i < matrix.length; i++) {
                maxm = Math.max(maxm, matrix[i][j]);
            }
            maxCol.add(maxm);
        }

        // Step 2: Check each row to find if the minimum element is in maxCol
        for (int i = 0; i < matrix.length; i++) {
            int minm = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                minm = Math.min(minm, matrix[i][j]);
            }
            if (maxCol.contains(minm)) {
                res.add(minm);
            }
        }

        return res;
    }

    /*
    Approach:
    1. Find the maximum elements in each column and store them in a set.
    2. For each row, find the minimum element and check if it exists in the set of column maximums.
    3. If it does, add it to the result list.

    Time Complexity:
    - O(m * n) where m is the number of rows and n is the number of columns.

    Space Complexity:
    - O(max(m, n)) for storing the result list and the set of column maximums.
    */
}
