/*
Find the sum of all left leaves in a given binary tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0; 
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, null);
        
        int result = sum;
        sum = 0;
        
        return result;
    }
    
    public void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            if (parent != null && parent.left == root) {
                sum += root.val;
            }
        }
        
        dfs(root.left, root);      
        dfs(root.right, root);
    }
}
