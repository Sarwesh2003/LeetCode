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
        
        int[] ans = diameter(root);
        
        return ans[0];
    }
    
    
    private int[] diameter(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] left = diameter(root.left);
        int[] right = diameter(root.right);
        
        int both = left[1] + right[1];
        
        int[] ans = new int[2];
        ans[0] = Math.max(left[0], Math.max(right[0], both));
        ans[1] = Math.max(left[1], right[1]) + 1;
        return ans;
    }
    
    //O(N^2) Approach
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