/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
             if(root==null){
            return 0;
        }
        
        int l=1;
        int r=1;
        
        if(root.left!=null){
            l= minDepth(root.left)+1;
        }
        
        if(root.right!=null){
            r=minDepth(root.right)+1;
        }
        
        if(l==1){
            return r;
        }
        
        if(r==1){
            return l;
        }
        
        return Math.min(l,r);
   
    }
}
