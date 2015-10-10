/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> li=new ArrayList<List<Integer>>();
        
        if(root==null){
            return li;
        }
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        ArrayList<Integer> al=new ArrayList<Integer>();
        al.add(0);
        
        TreeNode temp=null;
        
        int i=0;
        int ps=0;  // present
        int pv=-1;  // previous
        
        List curr=null;
        
        while(!q.isEmpty()){
            
            temp=q.poll();
            ps=al.get(i);
            
            if(ps!=pv){
                if(curr!=null)
                li.add(curr);
                curr=new ArrayList<Integer>();
            }
            
            curr.add(temp.val);
            
            if(temp.left!=null){
                q.add(temp.left);
                al.add(ps+1);
            }
            if(temp.right!=null){
                q.add(temp.right);
                al.add(ps+1);
            }
            
            pv=ps;
            i++;
            
        }
        
        li.add(curr);
        
        return li;
        
    }
}
