/*
https://leetcode.com/problems/binary-tree-postorder-traversal/description/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new LinkedList<Integer>();
        
        if(root == null) {
            return postorder;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                postorder.add(0, curr.val);
                curr = curr.right;
            } else {
                curr = stack.pop();
                curr = curr.left;
            }

        }
        
        //Collections.reverse(postorder);
        return postorder;
    }
}
