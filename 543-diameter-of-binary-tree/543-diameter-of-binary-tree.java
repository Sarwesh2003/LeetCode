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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int opt1 = diameterOfBinaryTree(root.left);
        int opt2 = diameterOfBinaryTree(root.right);
        int opt3 = height(root.left) + height(root.right) ;
        
        int ans = Math.max(opt1, Math.max(opt2, opt3));
        return ans;
    }
    
    
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        
        int ans = Math.max(left, right) + 1;
        return ans;
        
    }
}