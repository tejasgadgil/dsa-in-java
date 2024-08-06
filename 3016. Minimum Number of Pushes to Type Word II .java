import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    /**
     * This method calculates the minimum number of pushes needed to type the word on a classic mobile keypad.
     */
    public int minimumPushes(String word) {
        int pressCount = 0;

        // HashMap to store the frequency of each character.
        HashMap<Character, Integer> occurrence = new HashMap<>();
        for (char c : word.toCharArray()) {
            occurrence.put(c, occurrence.getOrDefault(c, 0) + 1);
        }
        
        // List to store the frequencies of distinct characters.
        List<Integer> distinctOcc = new ArrayList<>(occurrence.values());
        Collections.sort(distinctOcc);  // Sort the frequencies in ascending order.

        int j = distinctOcc.size() - 1;  // Start from the highest frequency.
        int counter = 0;  // Counter to keep track of the position in the sorted list.

        // Calculate the total number of pushes.
        while (j >= 0) {
            pressCount += ((counter / 8) + 1) * distinctOcc.get(j);
            j--;
            counter++;
        }

        return pressCount;  // Return the total number of pushes.
    }
}

// Algorithm/Approach: Frequency Counting and Sorting
//
// Time Complexity: O(m log m)
// - Counting the frequency of characters takes O(m) time, where m is the length of the word.
// - Sorting the frequencies takes O(m log m) time.
// - Therefore, the overall time complexity is O(m log m).
//
// Space Complexity: O(m)

