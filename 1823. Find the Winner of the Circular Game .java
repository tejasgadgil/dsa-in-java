import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findTheWinner(int n, int k) {
        // Initialize the circle with people labeled from 0 to n-1
        List<Integer> circle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }

        // Adjust k to be zero-based for easier calculations
        k--;
        int cur = 0;

        // Eliminate every k-th person until only one person is left
        while (n > 1) {
            // Calculate the index of the person to eliminate
            cur = (cur + k) % n;
            // Remove the person from the circle
            circle.remove(cur);
            // Decrease the number of people in the circle
            n--;
        }

        // Return the position of the last remaining person (convert to one-based index)
        return circle.get(0) + 1;
    }
}

// Iterative soln

// class Solution {
//     public int findTheWinner(int n, int k) {
//         int winner = 0;
//         for (int i = 2; i <= n; i++) {
//             winner = (winner + k) % i;
//         }
//         return winner + 1;  // Convert zero-based index to one-based index
//     }

// }

// Recursive Soln

// class Solution {
//     public int findTheWinner(int n, int k) {
//         return findWinner(n, k) + 1;  // Convert zero-based index to one-based index
//     }

//     private int findWinner(int n, int k) {
//         if (n == 1) {
//             return 0;  // Base case: only one person left
//         } else {
//             return (findWinner(n - 1, k) + k) % n;  // Recursive step
//         }
//     }

// }


// My Code (Using ArrayList):
// Time Complexity: 
// O(n^2)
// Space Complexity: 
// O(n)
  
// Optimized Iterative Version:
// Time Complexity: 
// O(n)
// Space Complexity: 
// O(1)
  
// Recursive Version:
// Time Complexity: 
// O(n)
// Space Complexity: 
// O(n)


