/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        
        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        
        int l = 0;
        int r = nums.length - 1;
        int m = (l+r)/2;
        
        TreeNode root = new TreeNode(nums[m]);
        boolean isLeft = true;
        convertToBST(nums, root, isLeft, l, m-1);
        convertToBST(nums, root, !isLeft, m+1, r);
        
        return root;
    }
    
    public void convertToBST(int[] nums, TreeNode curr, boolean isLeft, int l, int r) {
        if(r < l) {
            return;
        } 
        int m = (l+r)/2;
        TreeNode t = addNode(nums, curr, m, isLeft);
        boolean isl=true;
        convertToBST(nums, t, isl, l, m-1);
        convertToBST(nums, t, !isl, m+1, r);
    }
    
    public TreeNode addNode(int[] nums, TreeNode curr, int m, boolean isLeft) {
        if(isLeft) {
            curr.left=new TreeNode(nums[m]);
            return curr.left;
        } else {
            curr.right=new TreeNode(nums[m]);
            return curr.right; 
        }
    }
}
