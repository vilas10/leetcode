/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
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
public class CountCompleteTreeNodes {
    
    public int height = 0;
    public boolean found = false;
    public double count = 0;
    private static int h = 0;
    
    public int countNodes(TreeNode root) {
    if(root==null)
        return 0;
 
    int left = getLeftHeight(root)+1;    
    int right = getRightHeight(root)+1;
 
    if(left==right){
        return (2<<(left-1))-1;
    }else{
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    }
 
    public int getLeftHeight(TreeNode n){
    if(n==null) return 0;
 
    int height=0;
    while(n.left!=null){
        height++;
        n = n.left;
    }
        return height;
    }
 
    public int getRightHeight(TreeNode n){
    if(n==null) return 0;
 
    int height=0;
    while(n.right!=null){
        height++;
        n = n.right;
    }
    return height;
    }
    
    public int findheight(TreeNode root) {
        int h = 0;
        
        while(root.left != null) {
            h++;
            root = root.left;
        }
        
        return h;
    }
    
    public void dfs(TreeNode root){
        if(found) {
            return;
        }

        h++;
        
        if(root.left!=null){
            dfs(root.left);
        } else if(h == height-1) {
            found = true;
            return;
        }
        
        if(root.right!=null){
            dfs(root.right);
        } else if(h == height-1) {
            found = true;
            return;
        }
        
        count++;
        
        h--;
    }
    
    
    public int bfs(TreeNode root){
    
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        TreeNode x;
        int count=0;
        while(!q.isEmpty()){
            x=q.poll();
            if(x.left!=null){
                q.add(x.left);
            }
            if(x.right!=null){
                q.add(x.right);
            }
            count++;
        }
        
        return count;
    }
    
}
