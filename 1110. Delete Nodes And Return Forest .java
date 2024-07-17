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

    Set<Integer> to_del; // Set to store the nodes to be deleted
    Set<TreeNode> resultSet; // Set to store the resulting forest

    // Helper method to perform DFS and delete nodes
    public TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        // Recursively delete nodes in the left and right subtrees
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        
        // If the current node is to be deleted
        if (to_del.contains(node.val)) {
            // Add non-null children to the result set
            if (node.left != null) resultSet.add(node.left);
            if (node.right != null) resultSet.add(node.right);
            return null; // Return null to delete the current node
        }
        return node; // Return the current node if not deleted
    }

    // Main method to delete nodes and return the resulting forest
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_del = new HashSet<>();
        // Add nodes to be deleted into the set
        for (int num : to_delete) {
            to_del.add(num);
        }
        resultSet = new HashSet<>();
        
        dfs(root); // Perform DFS to delete nodes

        // If the root is not to be deleted, add it to the result set
        if (!to_del.contains(root.val)) resultSet.add(root);
        return new ArrayList<>(resultSet); // Convert the set to a list and return it
    }
}

/*
 * Approach:
 * 1. Use a set to keep track of nodes to be deleted.
 * 2. Use DFS to traverse the tree and delete nodes.
 * 3. If a node is deleted, add its non-null children to the result set.
 * 4. If the root is not deleted, add it to the result set.
 * 5. Convert the result set to a list and return it.
 *
 * Time Complexity: O(n)
 * - The algorithm visits each node exactly once, where n is the number of nodes in the tree.
 *
 * Space Complexity: O(n)
 * - The space complexity is O(n) due to the additional space used for the result set, the set of nodes to be deleted, and the recursive call stack.
 */
