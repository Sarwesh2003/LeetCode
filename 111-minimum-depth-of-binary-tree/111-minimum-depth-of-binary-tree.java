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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        solve(root, 0);
        return min;
    }
    
    public void solve(TreeNode root, int count){
        if(root == null){
            return;
        }
        count++;
        if(root.left == null && root.right == null)
            min = Math.min(min, count);
        
        solve(root.left, count);
        solve(root.right, count);
        
        
        return;
    }
}