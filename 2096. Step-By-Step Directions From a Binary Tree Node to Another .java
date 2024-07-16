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
    // Depth-First Search (DFS) to find the path from root to target node
    public boolean dfs(TreeNode node, StringBuilder path, int target) {
        if (node.val == target) {
            return true; 
        }
        if (node.left != null && dfs(node.left, path, target)) {
            path.append("L");
        } else if (node.right != null && dfs(node.right, path, target)) {
            path.append("R");
        }
        return path.length() > 0;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start_path = new StringBuilder();
        StringBuilder dest_path = new StringBuilder();
        // Find the path to startValue and destValue
        dfs(root, start_path, startValue);
        dfs(root, dest_path, destValue);
        start_path.reverse();
        dest_path.reverse();

        int i = 0;
        // Find the common prefix
        while (i < Math.min(start_path.length(), dest_path.length()) && start_path.charAt(i) == dest_path.charAt(i)) {
            i++;
        }

        // Remove the common prefix
        String start_remainder = start_path.toString().substring(i);
        String dest_remainder = dest_path.toString().substring(i);
        String res = "";

        // Move up from startValue to the common ancestor
        for (int j = 0; j < start_remainder.length(); j++) {
            res += 'U';
        }

        // Add the remaining path to destValue
        return res + dest_remainder;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h + n)

// Time Complexity:
// The DFS traversal takes O(n) time, where n is the number of nodes in the tree, since in the worst case, the DFS will visit every node.
// Constructing paths and finding the common prefix takes O(L) time, where L is the length of the paths.
// The overall time complexity is O(n+L), which simplifies to O(n) since L is at most n.
// Space Complexity:
// The space complexity is O(h), where h is the height of the tree. 
// This is due to the recursive call stack in the DFS traversal.
// Additional space for storing paths is O(L), but since L≤n, the overall space complexity is O(h+n).

// Approach:
// 1. Use DFS to find paths from the root to the start and destination nodes.
// 2. Compare the paths to find the common ancestor.
// 3. Replace the path from start to common ancestor with 'U' and append the path from the common ancestor to the destination.

