/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with same node values.
Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
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
public class FindDuplicateSubtrees {
    HashMap<String, TreeNode> map;
    List<TreeNode> result;
    Set<String> set;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList<TreeNode>();
        map = new HashMap<String, TreeNode>();
        set = new HashSet<String>();
        
        loadMap(root, "");
        
        return result;
    }
    
    public String loadMap(TreeNode root, String currkey) {
        if (root == null) return "N" + currkey;
        
        String key = "";
        key = loadMap(root.left, "L" + key);
        key = loadMap(root.right, "R" + key);
        
        key = key + root.val;

        if (map.containsKey(key) && !set.contains(key)) {
            result.add(map.get(key));
            set.add(key);
        } else {
            map.put(key, root);
        }
        
        return key + currkey;
    }
}
