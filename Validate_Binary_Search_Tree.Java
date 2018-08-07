/*
https://leetcode.com/problems/validate-binary-search-tree/description/
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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isValidBST(root, null, null);
    }
    
    boolean isValidBST(TreeNode curr, Integer min, Integer max) {
        if(curr == null) {
            return true;
        }
        
        if((min != null && curr.val <= min) || (max != null && curr.val >= max)) {
            return false;
        }
        
        return isValidBST(curr.left, min, curr.val) && isValidBST(curr.right, curr.val, max);
    }
}
