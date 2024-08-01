class Solution {
    /*
     * This method counts the number of senior passengers (age > 60) based on the details provided.
     */
    public int countSeniors(String[] details) {
        int senior = 0; // Initialize the count of senior passengers to zero.

        // Iterate through each passenger's details in the array.
        for(String psngr : details) {
            // Extract the age from the substring and check if it's greater than 60.
            if (Integer.parseInt(psngr.substring(11, 13)) > 60) {
                senior++; // Increment the count of senior passengers.
            }
        }
        return senior; // Return the final count of senior passengers.
    }
}

/**
 * Algorithm/Approach: Linear Scan
 * 
 * Time Complexity: O(n)
 * 
 * Space Complexity: O(1)
 */
