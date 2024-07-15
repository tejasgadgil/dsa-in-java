import java.util.HashMap;
import java.util.HashSet;

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
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // HashMap to store nodes by their values
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        // HashSet to track child nodes
        HashSet<Integer> children = new HashSet<>();

        // Iterate through the descriptions to create nodes and build the tree
        for (int i = 0; i < descriptions.length; i++) {
            // Create parent node if it does not exist
            nodes.putIfAbsent(descriptions[i][0], new TreeNode(descriptions[i][0]));
            // Create child node if it does not exist
            nodes.putIfAbsent(descriptions[i][1], new TreeNode(descriptions[i][1]));

            // Set the left or right child based on the description
            if (descriptions[i][2] == 1) {
                nodes.get(descriptions[i][0]).left = nodes.get(descriptions[i][1]);
            } else {
                nodes.get(descriptions[i][0]).right = nodes.get(descriptions[i][1]);
            }
            // Add the child node to the set of children
            children.add(descriptions[i][1]);
        }

        // Find the root node (a node that is not a child of any other node)
        for (int i = 0; i < descriptions.length; i++) {
            if (!children.contains(descriptions[i][0])) {
                return nodes.get(descriptions[i][0]);
            }
        }
        // Fallback in case the root node is not found
        return nodes.get(descriptions[0][0]);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
Approach: Binary Tree Construction
*/
