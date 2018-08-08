/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
public class KthSmallestElementInABST {
    private int kth;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        kth = 0;
        TreeNode kthSmallest = new TreeNode(0);
        
        dfs(root, k, kthSmallest);
        return kthSmallest.val;
    }
    
    void dfs(TreeNode curr, int k, TreeNode kthSmallest) {
        
        if(curr.left != null) {
            dfs(curr.left, k, kthSmallest);
        }
        
        kth++;
        if(k == kth) {
            kthSmallest.val = curr.val;
        }
        
        
        if(curr.right != null) {
            dfs(curr.right, k, kthSmallest);
        }
    }
}
