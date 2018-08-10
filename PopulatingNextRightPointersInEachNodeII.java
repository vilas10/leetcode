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
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        dfsConnect(root, null);
    }
    
    void dfsConnect(TreeLinkNode currNode, TreeLinkNode parent) {
        if(currNode == null) {
            return;
        }
        
        if(parent != null) {
            if(currNode == parent.left && parent.right != null) {
                currNode.next = parent.right;
            } else {
                
                TreeLinkNode temp = parent;
                
                while(temp.next != null) {
                    if(temp.next.left != null) {
                        currNode.next = temp.next.left;
                        break;
                    } else if(temp.next.right != null) {
                        currNode.next = temp.next.right;
                        break;
                    }
                    temp = temp.next;
                }
            }  
        } 
        
        dfsConnect(currNode.right, currNode);
        dfsConnect(currNode.left, currNode);
    }
}
