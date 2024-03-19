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
    public int maxDepth(TreeNode root) {
        
        if(root == null)
        {
            return 0;
        }
        //Keep iterating the left side of tree and find count
        int left = maxDepth(root.left);
        // keep iterating right side of tree and find count
        int right = maxDepth(root.right);
        // return 1 + max of both. adding 1 bcz we missed hte root not while calculating left,right
        return(1 + Math.max(left,right));
        
    }
}