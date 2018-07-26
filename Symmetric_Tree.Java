/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
    
    boolean isSymmetric(TreeNode left, TreeNode right) {
        boolean l = false;
        boolean r = false;
        
        if(left != null && right != null) {
            if(left.val == right.val) {
                l = isSymmetric(left.left, right.right);
                r = isSymmetric(left.right, right.left);
            } 
        } else if(left == null && right == null) {
            return true;
        } else {
            return false;
        }
        
        if(l == true && r == true) {
            return true;
        }
        
        return false;
    }
}
