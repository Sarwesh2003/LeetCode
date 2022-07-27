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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = null;
        
        root = insertInBst(nums, 0, n-1);
        
        return root;
    }
    
    public TreeNode insertInBst(int[] nums, int i, int j){
        if(i > j){
            // root = new TreeNode(val);
            return null;
        }
        int mid = (i+j) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = insertInBst(nums, i, mid - 1);
        root.right = insertInBst(nums, mid+1, j);
        
        return root;
    }
}