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

    //Have a BFS method to find the result
    //First go to the leaf node once we go to parent keep adding 1 
    // Compare the left list with right list
    // Count No.of pairs possible
    // Then only sent those units which is less than d-1 in new List to the parent
    // return the No. of Pairs. 
    public ArrayList<Integer> dfs(TreeNode root, int dist)
    {
        // If the root value is null return null
        if(root == null)
        {
            return new ArrayList<>();
        }
        // If the left and right is null then its leaf node
        // then return list with 1 
        if(root.left == null && root.right==null)
        {
            return new ArrayList<>(Arrays.asList(1));
        }
        // iterate to the left of tree then right
        ArrayList<Integer> leftv = dfs(root.left,dist);
        ArrayList<Integer> rightv = dfs(root.right,dist);

        // Compare left and right list and find number of pairs possible
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
        // Create a new list 
        ArrayList<Integer> parent = new ArrayList<>();
        // Iterate to the left list and increment all the value which is less than d-1 and to parent list and sent to parent
        for(Integer lv : leftv)
        {
            if(lv+1 <= dist)
            {
                parent.add(lv+1);
            }
        }
        // Iterate to the right and increment the value and add thopse to new parent list
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