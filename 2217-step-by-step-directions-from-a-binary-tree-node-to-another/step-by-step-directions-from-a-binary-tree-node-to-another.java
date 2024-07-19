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
    // Create a String Builder for rootToSource, rootToDest
    // Create a Helper function calculatePath. 
    public StringBuilder rootToSource = new StringBuilder("");
    public StringBuilder rootToDest = new StringBuilder(""); 
    
    // Main Function
    public String getDirections(TreeNode root, int startValue, int destValue) 
    {
        // call calculatePath from root to src node
        // call calculatePath from root to dedc node
        calculatePath(root,startValue,rootToSource);
        calculatePath(root,destValue,rootToDest);
        // Create a result string
        StringBuilder result = new StringBuilder();
        int l=0;
        while(l<rootToSource.length() && l<rootToDest.length() && rootToSource.charAt(l) == rootToDest.charAt(l))
        {
            l++;
        }
        // Append 'U' of result of length rootToDesc;
        for(int i=l;i<rootToSource.length();i++)
        {
            result.append('U');
        }
        // Append same rootToDesc string to Result;
        for(int i=l;i<rootToDest.length();i++)
        {
            result.append(rootToDest.charAt(i));
        }
        // retun result.
        return result.toString();
    }
    /*
        -> Main Idea.
        -> Find the path from root to src
        -> Find the path from root to desc
        -> rootToSrc with 'U' and rest append as ease
    */ 
    public boolean calculatePath(TreeNode root, int destValue, StringBuilder path)
    {
        // if root is null return null that means we have reached the end.
        if(root == null)
        {
            return false;
        }
        // id we find the root value == required value return true
        if(root.val == destValue)
        {
            return true;
        }

        // Step 1 append L and move left and find the required value
        // If we find return true
        path.append('L');
        if (calculatePath(root.left,destValue,path) == true)
        {
            return true;
        }
        // If we dont find on the left.
        // remove L from the string
        // Add R to the string and move right and find value 
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        // If we find the value in the right then return true 
        if(calculatePath(root.right,destValue,path) == true)
        {
            return true;
        }
        // If we dont find the value on right also return false
        path.deleteCharAt(path.length() - 1);
        // If we dont find on both left and right return false since not found
        return false;
    }
}