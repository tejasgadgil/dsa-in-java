class Solution {
    public int minOperations(String[] logs) {
        // Initialize a counter to keep track of how far we are from the main folder
        int away = 0;
        
        // Iterate through each log entry
        for (int i = 0; i < logs.length; i++) {
            // If the log entry is "../" and we are not already at the main folder
            if (logs[i].equals("../") && (away > 0)) {
                // Move one folder up (closer to the main folder)
                away--;
            } 
            // If the log entry is "./" (current directory) or "../" but we are at the main folder
            else if (logs[i].equals("./") || (logs[i].equals("../") && (away == 0))) {
                // Do nothing, continue to the next log entry
                continue;
            } 
            // Otherwise, the log entry represents moving into a subdirectory
            else {
                // Move one folder deeper (further from the main folder)
                away++;
            }
        }
        
        // Return the number of steps away from the main folder
        return away;
    }
}

// Time Complexity
// O(n)
// Space Complexity
// O(1)
// Algorithm Approach
// Greedy 
