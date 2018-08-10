/*
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) {
            return;
        }
        
        dfsConnect(root, null);
    }
    
    void dfsConnect(TreeLinkNode currNode, TreeLinkNode parent) {
        
        if(currNode.left != null) {
            currNode.left.next = currNode.right;
            dfsConnect(currNode.left, currNode);
        }
        
        if(currNode.right != null) {
            if(currNode.next != null) {
                currNode.right.next = currNode.next.left;
            }
            
            dfsConnect(currNode.right, currNode);
        }
        
        if(parent != null) {
            if(currNode == parent.left) {
                currNode.next = parent.right;
            } else {
                if(parent.next != null) {
                    currNode.next = parent.next.left;
                }
            }
        }
    }
}
