/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
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
class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        
        return dfs(s, t);
    }
    
    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) return false;
        
        boolean isSubtree = false;
        if (s.val == t.val) {
            if (checkIfSubtree(s, t)) return true;
        }
        
        isSubtree = dfs(s.left, t);
        if (!isSubtree) isSubtree = dfs(s.right, t);
        
        return isSubtree;
    }
    
    public boolean checkIfSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        if (!checkIfSubtree(s.left, t.left)) return false;
        
        return checkIfSubtree(s.right, t.right);
    }
}
