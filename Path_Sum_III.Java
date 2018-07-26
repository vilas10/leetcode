/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
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
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        pathSum1(root, sum);
        int result = count;
        count = 0;
        
        return result;
    }
    
    public List<Integer> pathSum1(TreeNode root, int sum) {
        if (root == null) return new LinkedList<>();
        
        List<Integer> leftsums = pathSum1(root.left, sum);
        List<Integer> rightsums = pathSum1(root.right, sum);
        
        List<Integer> newsums = new LinkedList<>();
        newsums.add(root.val);
        
        if (root.val == sum) count++;
        
        if (leftsums.size() == 0 && rightsums.size() == 0)
            return newsums;
        
        for (Integer l: leftsums) {
            newsums.add(l + root.val);
            if (l + root.val == sum) count++;
        }
        
        for (Integer r: rightsums) {
            newsums.add(r + root.val);
            if (r + root.val == sum) count++;
        }
        
        return newsums;
    }
}
