class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a set to store all allowed characters
        HashSet<Character> consistent = new HashSet<>();
        
        // Populate the set with allowed characters from the string
        for (char i : allowed.toCharArray()) {
            consistent.add(i);
        }
        
        int n = words.length;  // Total number of words
        int counter = n;  // Start with the assumption that all words are consistent
        
        // Loop through each word in the words array
        for (int j = 0; j < n; j++) {
            int m = words[j].length();  // Length of the current word
            
            // Check each character in the current word
            for (int k = 0; k < m; k++) {
                // If the character is not in the allowed set, decrement the counter and break
                if (!consistent.contains(words[j].charAt(k))) {
                    counter--;
                    break;
                }
            }
        }
        
        return counter;  // Return the number of consistent strings
    }
}

/*
Algorithm/Approach: HashSet and String Traversal

Time Complexity: O(n * m)
- 'n' is the number of words in the input array.
- 'm' is the average length of each word.

Space Complexity: O(a)
- 'a' is the number of unique characters in the `allowed` string (up to 26 characters since the input only includes lowercase letters).
*/
