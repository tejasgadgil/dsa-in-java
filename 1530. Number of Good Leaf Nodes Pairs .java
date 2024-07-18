/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    int pairs = 0; // Variable to store the count of good leaf node pairs

    // Helper method for DFS traversal
    public ArrayList<Integer> dfs(TreeNode node, int distance){
        if(node == null) return new ArrayList<Integer>(); // Base case: If node is null, return an empty list
        if(node.left == null && node.right == null) return new ArrayList<Integer>(Arrays.asList(1)); // If node is a leaf, return a list with distance 1

        ArrayList<Integer> left_list = dfs(node.left, distance); // Recursive call on left subtree
        ArrayList<Integer> right_list = dfs(node.right, distance); // Recursive call on right subtree

        // Check all pairs of leaf nodes from left and right subtrees
        for(int l : left_list){
            for(int r : right_list){
                if(l + r <= distance){
                    pairs++; // Increment pairs count if the sum of distances is less than or equal to the given distance
                }
            }
        }

        // Increment distances of all leaf nodes in the current subtree by 1
        ArrayList<Integer> dist_list = new ArrayList<Integer>();
        for(int i = 0; i < left_list.size(); i++){
            dist_list.add(left_list.get(i) + 1);
        }
        for(int i = 0; i < right_list.size(); i++){
            dist_list.add(right_list.get(i) + 1);
        }

        return dist_list; // Return the updated list of distances
    }

    public int countPairs(TreeNode root, int distance) {
        ArrayList<Integer> res = dfs(root, distance); // Start DFS traversal from the root
        return pairs; // Return the count of good leaf node pairs
    }
}

/*

Approach:
1. Perform a DFS traversal on the binary tree.
2. For each node, gather distances of leaf nodes from its left and right subtrees.
3. For each pair of leaf nodes (one from the left subtree and one from the right subtree), check if their combined distance is less than or equal to the given distance.
4. If so, increment the count of good leaf node pairs.
5. Return the total count of good leaf node pairs.

Time Complexity: O(n^3) in the worst case
Space Complexity: O(n)

*/

