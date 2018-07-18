/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String s = "" + t.val;
        if (t.left == null && t.right == null) return s;
        if (t.left != null)  s += "(" + tree2str(t.left) + ")";
        if (t.left == null && t.right != null) s += "()";
        if (t.right != null) s += "(" + tree2str(t.right) + ")";
        
        return s;
    }
}
