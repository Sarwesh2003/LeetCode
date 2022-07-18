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
    int count = 0;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right) + 1;
        return max;
    }
    
    // TLE
    // private void solve(TreeNode node){
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(node);
    //     q.add(null);
    //     while(q.size() > 0){
    //         TreeNode temp = q.peek();
    //         q.remove();
    //         if(temp == null){
    //             count++;
    //             if(q.size() > 0){
    //                 q.add(null);
    //             }
    //         }else{
    //             if(temp.left != null){
    //                 q.add(temp.left);
    //             }
    //             if(temp.right != null){
    //                 q.add(temp.right);
    //             }
    //         }
    //     }
    // }
}