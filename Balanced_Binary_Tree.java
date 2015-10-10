/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
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
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        if(root.left == null && root.right == null) {
            return true;
        }
        
        int ret = checkBalanced(root);
        if(ret == -1) {
            return false;
        } else {
            return true;
        }
    }
    
    public int checkBalanced(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int hLeft = 0;
        int hRight = 0;
        int ret = -1;
        
        if(root.left != null) {
            hLeft = checkBalanced(root.left);
            if(hLeft == ret) {
                return ret;
            }
        }
        if(root.right != null) {
            hRight = checkBalanced(root.right);
            if(hRight == ret) {
                return ret;
            }
        }
        
        if(Math.abs(hLeft - hRight) <= 1) {
                ret = Math.max(hLeft, hRight) + 1;
        }
        
        return ret;
    }
}
