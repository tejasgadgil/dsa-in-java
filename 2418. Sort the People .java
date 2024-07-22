import java.util.Arrays;
import java.util.Collections;

class Solution {

    // Partition method for quicksort
    int partition(String[] names, int[] heights, int l, int h) {
        int pivot = heights[l]; // Choose the pivot as the first element
        int i = l; // Initialize i to the leftmost index
        int j = h; // Initialize j to the rightmost index

        // Repeat until i and j cross
        while (i < j) {
            // Increment i until an element larger than or equal to the pivot is found
            while (i < h && heights[i] <= pivot) {
                i++;
            }
            // Decrement j until an element smaller than or equal to the pivot is found
            while (j > l && heights[j] >= pivot) {
                j--;
            }
            // Swap elements at i and j if they have not crossed
            if (i < j) {
                int temp = heights[i];
                heights[i] = heights[j];
                heights[j] = temp;

                String tmp = names[i];
                names[i] = names[j];
                names[j] = tmp;
            }
        }
        
        // Place the pivot in its correct position
        int temp = heights[j];
        heights[j] = heights[l];
        heights[l] = temp;

        String tmp = names[j];
        names[j] = names[l];
        names[l] = tmp;
        
        return j; // Return the index of the pivot
    }

    // Quicksort method to sort the arrays
    void quicksort(String[] names, int[] heights, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivot = partition(names, heights, low, high);
            // Recursively sort elements before and after the pivot
            quicksort(names, heights, low, pivot - 1);
            quicksort(names, heights, pivot + 1, high);
        }
    }

    // Method to sort people by their heights
    public String[] sortPeople(String[] names, int[] heights) {
        quicksort(names, heights, 0, heights.length - 1); // Sort the arrays using quicksort
        Collections.reverse(Arrays.asList(names)); // Reverse the sorted names to get descending order
        return names; // Return the sorted names
    }
}

// Approach: Quick Sort
// Time Complexity: The average-case time complexity of quicksort is O(nlogn). However, in the worst case (when the pivot is always the smallest or largest element), it can degrade to O(n^2).
// Space Complexity: Quicksort is an in-place sorting algorithm, so it uses O(logn) space on the call stack due to recursion.
