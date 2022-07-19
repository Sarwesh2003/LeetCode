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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        return Sum(root, targetSum, 0);
     
    }
    public boolean Sum(TreeNode root, int tgt, int sum){
        if(root == null) return false;
        
        sum += root.val;
        if(tgt == sum && root.left == null && root.right == null)   return true;
        
        if(Sum(root.left, tgt, sum) || Sum(root.right, tgt, sum)){
            return true;
        }
        return false;
        
    }
}