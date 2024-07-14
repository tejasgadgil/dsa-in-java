class Solution {
    public String getSmallestString(String s) {
        // Convert the input string into a character array for easy manipulation
        char[] charArr = s.toCharArray();
        
        // Traverse the string up to the second-to-last character
        for (int i = 0; i < s.length() - 1; i++) {
            // Check if the current character and the next character have the same parity (both even or both odd)
            if (Character.getNumericValue(s.charAt(i)) % 2 == Character.getNumericValue(s.charAt(i + 1)) % 2 
                && Character.getNumericValue(s.charAt(i)) > Character.getNumericValue(s.charAt(i + 1))) {
                
                // Swap the characters if the current character is greater than the next character
                char temp = charArr[i];
                charArr[i] = charArr[i + 1];
                charArr[i + 1] = temp;
                
                // Exit the loop after performing the swap
                break;
            }
        }
        
        // Convert the character array back to a string
        String smallest = "";
        for (int i = 0; i < s.length(); i++) {
            smallest += charArr[i];
        }
        
        return smallest;
    }
}

// Time Complexity
// O(N)
// Space Complexity
// O(n).
// Algorithm Approach
// Greedy approach
