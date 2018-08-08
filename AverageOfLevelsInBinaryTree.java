/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
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
class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) return result;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int counter = queue.size();
            int n = counter;
            double sum = 0;
            
            while(counter > 0) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                
                counter--;
            }
            
            result.add(new Double(sum/n));
        }
        
        return result;
    }
}
