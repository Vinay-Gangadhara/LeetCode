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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>(); 
        if(root == null)
        {
            return result;
        }      
        que.offer(root);
        Boolean ltor = true;

        while(!que.isEmpty())
        {
            List<Integer> ds = new ArrayList<>();
            int length = que.size();

            for(int i=0;i<length;i++)
            {
                if(que.peek().left != null)
                {
                    que.offer(que.peek().left);
                }
                if(que.peek().right != null)
                {
                    que.offer(que.peek().right);
                }
                if(ltor == true)
                {
                    ds.add(que.poll().val);
                }
                if(ltor == false)
                {
                    ds.add(0,que.poll().val);
                }
            }
            ltor = !ltor;
            result.add(ds);
        }
        return result;
    }
}