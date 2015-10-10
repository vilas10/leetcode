/**
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }   
        
        TreeNode x=new TreeNode(root.val);
        
        invertTree2(root,x);
        
        return x;
    }
    
    public void invertTree2(TreeNode root, TreeNode x){
        
        if(root.left!=null){
            TreeNode l=new TreeNode(root.left.val);
            x.right=l;
            invertTree2(root.left,x.right);
        }
        
        if(root.right!=null){
            TreeNode r=new TreeNode(root.right.val);
            x.left=r;
            invertTree2(root.right,x.left);
        }
    }
}
