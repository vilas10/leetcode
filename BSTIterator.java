/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private List<TreeNode> path;
    
    public BSTIterator(TreeNode root) {
        
        if(root == null) {
            this.path = null;
            return;
        }
        
        this.path = new ArrayList<TreeNode>();
        path.add(root);
        while(root.left != null) {
            this.path.add(root.left);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        if(path == null || path.size() == 0) {
            return false;
        }
        
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        int pos = path.size() - 1;
        TreeNode temp = path.get(pos);
        int val = temp.val;
        if(temp.right != null) {
            path.add(temp.right);
            temp = temp.right;
            while(temp.left != null) {
                path.add(temp.left);
                temp = temp.left;
            }
        }
            
        path.remove(pos);
        
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
