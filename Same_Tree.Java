/*
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
       boolean left = false;
       boolean right = false;
       if(p==null && q==null){
            return true;
       }else if(p!=null && q!=null){
           if(p.val != q.val) {
               return false;
           }
           
           left = isSameTree(p.left, q.left);
           right = isSameTree(p.right, q.right);
        } else {
            return false;
        }
        
        return left && right;
    }
}
