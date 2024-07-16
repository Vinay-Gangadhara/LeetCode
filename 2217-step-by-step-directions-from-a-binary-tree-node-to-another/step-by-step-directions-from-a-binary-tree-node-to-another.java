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
    public StringBuilder rootToSource = new StringBuilder("");
    public StringBuilder rootToDest = new StringBuilder(""); 
    public String getDirections(TreeNode root, int startValue, int destValue) 
    {
        calculatePath(root,startValue,rootToSource);
        calculatePath(root,destValue,rootToDest);
        StringBuilder result = new StringBuilder();
        int l=0;
        while(l<rootToSource.length() && l<rootToDest.length() && rootToSource.charAt(l) == rootToDest.charAt(l))
        {
            l++;
        }

        for(int i=l;i<rootToSource.length();i++)
        {
            result.append('U');
        }

        for(int i=l;i<rootToDest.length();i++)
        {
            result.append(rootToDest.charAt(i));
        }
        
        return result.toString();
    }

    public boolean calculatePath(TreeNode root, int destValue, StringBuilder path)
    {
        if(root == null)
        {
            return false;
        }

        if(root.val == destValue)
        {
            return true;
        }
        path.append('L');
        if (calculatePath(root.left,destValue,path) == true)
        {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        if(calculatePath(root.right,destValue,path) == true)
        {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}