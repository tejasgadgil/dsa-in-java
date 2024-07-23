import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Create a frequency map to count the occurrences of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Convert the primitive int array to an Integer array
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        // Sort the Integer array using a custom comparator
        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a); // Sort in descending order if frequencies are equal
            }
            return Integer.compare(freq.get(a), freq.get(b)); // Sort in ascending order based on frequency
        });

        // Convert the sorted Integer array back to a primitive int array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        // Return the sorted array
        return nums;
    }
}

// Approach:
// Comparator
// Time Complexity:
// O(nlogn).
// Space Complexity:
// O(n).
