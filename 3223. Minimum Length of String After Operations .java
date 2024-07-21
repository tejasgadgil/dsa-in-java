class Solution {
    public int minimumLength(String s) {
        // Initialize the length to the length of the input string
        int length = s.length();
        // Create a HashMap to store the occurrences of each character
        HashMap<Character, Integer> occurrences = new HashMap<>();
        
        // Iterate through each character in the string
        for(int i = 0; i < s.length(); i++) {
            // Get the current character
            char c = s.charAt(i);
            // Increment the count of the current character in the HashMap
            occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
            // If the count of the current character reaches 3
            if(occurrences.get(c) == 3) {
                // Reset the count of the current character to 1
                occurrences.put(c, 1);
                // Decrease the length by 2 as we remove two occurrences of this character
                length -= 2;
            }
        }
        // Return the updated length
        return length;
    }
}

/*
Approach:
1. Initialize the length to the length of the input string.
2. Use a HashMap to store the occurrences of each character.
3. Iterate through the string and increment the count of each character in the HashMap.
4. If the count of any character reaches 3, reset it to 1 and decrease the length by 2.
5. Return the updated length.

Time Complexity:
- Iterating through the string takes O(n), where n is the length of the string.
- Each operation on the HashMap (get, put) takes O(1) on average.
- Therefore, the overall time complexity is O(n).

Space Complexity:
- The HashMap stores counts for each unique character in the string.
- In the worst case, the space complexity is O(m), where m is the number of unique characters.
*/
