/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
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
public class Solution {
    
    public boolean flag = false;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(flag) {
            return true;
        }
        if(root == null) {
            return false;
        }
        
        
        boolean l = false;
        boolean r = false;
        
        if(root.left==null && root.right==null && sum-root.val==0) {
            flag = true;
            return true;
        }
        
        if(root.left != null && !flag) {
            l = hasPathSum(root.left, sum-root.val);
        }
        
        if(root.right != null && !flag) {
            r = hasPathSum(root.right, sum-root.val);
        }
        
        if(l || r) {
            return true;
        }
        
        return false;
    }
}
