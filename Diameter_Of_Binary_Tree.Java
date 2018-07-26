/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
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
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {                
        diameterOfBinaryTree1(root);        
        
        return diameter;
    }
    
    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        
        int l = diameterOfBinaryTree1(root.left);        
        int r = diameterOfBinaryTree1(root.right);
        
        diameter = Math.max(diameter, l + r);
        
        return Math.max(l, r) + 1;
    }
}
