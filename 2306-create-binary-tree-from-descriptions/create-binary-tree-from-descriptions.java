/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer,TreeNode> map = new HashMap<>();
        Map<Integer, Boolean> hasparent = new HashMap<>();

        for(int[] desc : descriptions)
        {
            int parent_value = desc[0];
            int child_value = desc[1];
            int leftOrRight = desc[2];

            TreeNode parent;
            TreeNode child;
            if(map.containsKey(parent_value))
            {
                parent = map.get(parent_value);
            }
            else
            {
                parent = new TreeNode(parent_value);
            }
            if(map.containsKey(child_value))
            {
                child = map.get(child_value);
            }
            else
            {
                child = new TreeNode(child_value);
            }

            if(leftOrRight == 1)
            {
                parent.left = child;
            }
            else
            {
                parent.right = child;
            }
            hasparent.put(child_value, true);
            map.put(parent_value,parent);
            map.put(child_value,child);
        }
        TreeNode result = null;
       for(Map.Entry<Integer, TreeNode> entry : map.entrySet())
        {
            if(!hasparent.containsKey(entry.getKey()))
            {   
                result = entry.getValue();
            }
        } 
        return result;
    }
}