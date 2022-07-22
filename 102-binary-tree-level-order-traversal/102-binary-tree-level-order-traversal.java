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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        
        while(q.size() > 0){
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; ++i){
                TreeNode node = q.remove();
                list.add(node.val);
                if(node != null && node.left != null)
                    q.add(node.left);
                if(node != null && node.right != null)
                    q.add(node.right);
            }
            ans.add(list);
        }
        return ans;
        
    }
}