/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
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
public class BinaryTreeRightSideView {
    static int max = 1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightview = new ArrayList<Integer>();
        if(root == null) {
            return rightview;
        }
        
        rightview.add(root.val);
        rightSideView(root, 0, rightview);
        max = 1;
        return rightview;
    }
    
    void rightSideView(TreeNode currNode, int level, List<Integer> rightview) {
        if(currNode == null) {
            return;
        }
        
        if(currNode.right != null) {
            if(max == level+1) {
                rightview.add(currNode.right.val);
                max++;
            }
            rightSideView(currNode.right, level+1, rightview);
        }
        
        if(currNode.left != null) {
            if(max == level+1) {
                rightview.add(currNode.left.val);
                max++;
            }
            
            rightSideView(currNode.left, level+1, rightview);
        }
    }
}
