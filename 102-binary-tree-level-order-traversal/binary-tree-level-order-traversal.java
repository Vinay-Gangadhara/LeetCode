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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        // For Level order traversal we maintain a queue
        // we go on each element in queue and keep adding its left and right;
        // before iterating for left and right find the size to get the level(size);
        if(root == null)
        {
            return result;
        }
        que.offer(root);
        while(!que.isEmpty())
        {
            int level = que.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0; i<level; i++)
            {
                if(que.peek().left != null)
                {
                    que.offer(que.peek().left);
                }
                if(que.peek().right != null)
                {
                    que.offer(que.peek().right);
                }
                ls.add(que.poll().val);
            }
            result.add(ls);
        }
        
        return result;
    }
}