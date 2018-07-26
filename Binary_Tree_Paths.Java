/*
Given a binary tree, return all root-to-leaf paths.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        
        if(root == null) {
            return result;
        }
        
        
        String current = "";
        
        binaryTreePathsList(root, current, result);
        
        return result;
    }
    
    public void binaryTreePathsList(TreeNode root, String current, List<String> result) {
        
        current = current + root.val + "->";
        
        if(root.left != null) {
            binaryTreePathsList(root.left, current, result);
        }
        
        if(root.right != null) {
            binaryTreePathsList(root.right, current, result);
        }
        
        current = current.substring(0, current.length() - 2);
        if(root.left == null && root.right == null) {
            result.add(current);
        }
        //current = current.substring(0, current.length() - 1);
    }
}
