/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.
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
    //public static int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        //Integer sum = new Integer(0);
        List<Integer> pathnum = new ArrayList<Integer>();
        dfs(root, 0, pathnum);
        //int result = sum;
        int sum = 0;
        
        for(int i=0; i<pathnum.size(); i++) {
            sum += pathnum.get(i);
        }
        return sum;
    }
    
    void dfs(TreeNode curr, int pathsum, List<Integer> pathnum) {
        pathsum = pathsum*10 + curr.val;
        if(curr.left != null) {
            dfs(curr.left, pathsum, pathnum);
        }
        
        if(curr.right != null) {
            dfs(curr.right, pathsum, pathnum);
        }
        
        if(curr.left == null && curr.right == null) {
            //sum += pathsum;
            pathnum.add(pathsum);
        }
    }
}
