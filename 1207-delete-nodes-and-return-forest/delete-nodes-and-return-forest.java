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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // Create an set for O(1) retrival for nodes to be deleted info.
        Set<Integer> hs = new HashSet<>();
        List<TreeNode> ll = new ArrayList<>();
        for(int i: to_delete)
        {
            hs.add(i);
        }

        helperFunction(root,hs,ll);

        // If the root node also needs to be deleted add that also to the list
        if(!hs.contains(root.val))
        {
            ll.add(root);
        }

        return ll;
    }

    public TreeNode helperFunction(TreeNode root, Set<Integer> hs, List<TreeNode> ll)
    {
        // If the root is null return null
        if(root == null)
        {
            return null;
        }
        // Hold the left and right values for the root node
        // Iterate to the left first then to the right by backtracking
        root.left = helperFunction(root.left,hs,ll);
        root.right = helperFunction(root.right,hs,ll);

        // If the root node need to be deleted 
        // Add root's left and right to the list and return null
        if(hs.contains(root.val))
        {
            if(root.left != null)
            {
                ll.add(root.left);
            }
            if(root.right != null)
            {
                ll.add(root.right);
            }
            return null;
        }

        // if the parent root should not be deleted then return the root itself.
        else
        {
            return root;
        }
    }
}