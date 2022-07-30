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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        
        solve(root, low, high);
        return sum;
    }
    
    public void solve(TreeNode root, int low, int high){
        if(root == null)
            return;
        
        if(root.val >= low && root.val <=high){
            sum += root.val;
            solve(root.left, low, high);
            solve(root.right, low, high);
        }else if(root.val > high){
            solve(root.left, low, high);
        }else{
            solve(root.right, low, high);
        }
    }
}