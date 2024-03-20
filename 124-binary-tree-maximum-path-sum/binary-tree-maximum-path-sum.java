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
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxsum(root,maxi);
        return maxi[0];
    }

    public int maxsum(TreeNode root, int[] maxi)
    {
        if(root == null)
        {
            return 0;
        }
        // Find the left sum
        int left = Math.max(0,maxsum(root.left,maxi));
        // Find the right sum
        int right = Math.max(0,maxsum(root.right,maxi));
        // find the max value 
        maxi[0] = Math.max(maxi[0],(root.val+(left+right)));
        // decide which path to take left or right by max(left,right)
        return (root.val + Math.max(left,right));
    }
}