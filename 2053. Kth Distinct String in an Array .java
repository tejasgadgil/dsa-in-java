import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    /**
     * This method finds the k-th distinct string in the array.
     */
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> firstOcc = new HashMap<>();  // HashMap to store the occurrence count of each string.
        int n = arr.length;  // Length of the array.

        // Count the occurrences of each string in the array.
        for (int i = 0; i < n; i++) {
            firstOcc.put(arr[i], firstOcc.getOrDefault(arr[i], 0) + 1);
        }

        ArrayList<String> distinct = new ArrayList<>();  // List to store distinct strings.

        // Collect strings that occur exactly once.
        for (int i = 0; i < n; i++) {
            if (firstOcc.get(arr[i]) == 1) {
                distinct.add(arr[i]);
            }
        }

        // Check if there are at least k distinct strings.
        if (distinct.size() < k) {
            return "";
        }

        // Return the k-th distinct string.
        return distinct.get(k - 1);
    }
}

// Algorithm/Approach: HashMap and ArrayList
//
// Time Complexity: O(n)
//
// Space Complexity: O(n)
