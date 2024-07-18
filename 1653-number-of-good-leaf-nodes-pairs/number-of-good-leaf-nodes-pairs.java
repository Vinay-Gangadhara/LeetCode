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
    public int noOfPairs = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return noOfPairs;
    }

    public ArrayList<Integer> dfs(TreeNode root, int dist)
    {
        if(root == null)
        {
            return new ArrayList<>();
        }
        if(root.left == null && root.right==null)
        {
            return new ArrayList<>(Arrays.asList(1));
        }

        ArrayList<Integer> leftv = dfs(root.left,dist);
        ArrayList<Integer> rightv = dfs(root.right,dist);

        for(Integer lv : leftv)
        {
            for(Integer rv : rightv)
            {
                if(lv+rv <= dist)
                {
                    noOfPairs++;
                }
            }
        }

        ArrayList<Integer> parent = new ArrayList<>();
        for(Integer lv : leftv)
        {
            if(lv+1 <= dist)
            {
                parent.add(lv+1);
            }
        }

        for(Integer rv : rightv)
        {
            if(rv+1 <= dist)
            {
                parent.add(rv+1);
            }
        }
        return parent;
    }
}