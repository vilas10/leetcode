/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Path p = new Path();
        
        if(root == null) {
            return result;
        }
        
        pathSumEval(root, sum, p, result);
        
        return result;
    }
    
    public void pathSumEval(TreeNode root, int sum, Path p, List<List<Integer>> result) {
        p.path.add(root.val);
        p.pathsum += root.val;
        p.size++;
        
        if(root.left != null) {
            pathSumEval(root.left, sum, p, result);
        }
        
        if(root.right != null) {
            pathSumEval(root.right, sum, p, result);
        }
        
        if(root.left == null && root.right == null) {
            if(p.pathsum == sum) {
                result.add(new ArrayList<Integer>(p.path));
            }
        }
        
        p.pathsum -= p.path.get(p.size);
        p.path.remove(p.size);
        p.size--;
        
    }
}

class Path {
    List<Integer> path;
    int pathsum;
    int size;
    
    Path() {
        path = new ArrayList<Integer>();
        pathsum = 0;
        size = -1;
    }
}
