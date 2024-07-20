class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];  // Initialize the resulting matrix

        // Fill the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Get the minimum of rowSum[i] and colSum[j]
                int minm = Math.min(rowSum[i], colSum[j]);
                // Assign the minimum value to the matrix cell
                matrix[i][j] = minm;
                // Subtract the assigned value from rowSum and colSum
                rowSum[i] -= minm;
                colSum[j] -= minm;
            }
        }
        return matrix;
    }

    /*
    Approach: Greedy Algo
    1. Iterate through each cell of the matrix.
    2. For each cell, assign the minimum value between the remaining row sum and column sum.
    3. Deduct the assigned value from both the row sum and column sum.
    4. Continue until all cells are filled.

    Time Complexity:
    - O(m * n) where m is the number of rows and n is the number of columns.

    Space Complexity:
    - O(m * n) for the resulting matrix.
    */
}
