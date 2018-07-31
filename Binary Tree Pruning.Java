/*
We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        dfs(null, root);
        
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;    
        }
            
        return root;
    }
    
    public void dfs(TreeNode parent, TreeNode root) {
        if (root == null) return;
        
        dfs(root, root.left);
        dfs(root, root.right);
        
        if (parent != null && root.val == 0 && root.left == null && root.right == null) {
            if (parent.left == root) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }
}
