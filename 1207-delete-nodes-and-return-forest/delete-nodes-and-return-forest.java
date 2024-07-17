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
        
        Set<Integer> hs = new HashSet<>();
        List<TreeNode> ll = new ArrayList<>();
        for(int i: to_delete)
        {
            hs.add(i);
        }

        helperFunction(root,hs,ll);

        if(!hs.contains(root.val))
        {
            ll.add(root);
        }

        return ll;
    }

    public TreeNode helperFunction(TreeNode root, Set<Integer> hs, List<TreeNode> ll)
    {
        if(root == null)
        {
            return null;
        }

        root.left = helperFunction(root.left,hs,ll);
        root.right = helperFunction(root.right,hs,ll);

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
        else
        {
            return root;
        }
    }
}