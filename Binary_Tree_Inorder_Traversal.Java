/*
Given a binary tree, return the inorder traversal of its nodes' values.

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        if(root == null) {
            return inorder;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        
        while(!stack.isEmpty() || temp != null) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            
            temp = stack.pop();
            inorder.add(temp.val);
            
            temp = temp.right;
        }
        
        return inorder;
    }
}
