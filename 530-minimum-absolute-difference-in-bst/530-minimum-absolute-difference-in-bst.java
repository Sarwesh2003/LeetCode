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
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode p = curr.left;
                while(p.right != null){
                    p = p.right;
                }
                p.right = curr.right;
                curr.right = curr.left;
            }
            curr.left = null;
            curr = curr.right;
        }
        
        TreeNode temp = root;
        int min = Integer.MAX_VALUE;
        while(temp.right != null){
            TreeNode temp1 = temp.right;
            while(temp1 != null){
                int diff = Math.abs(temp.val - temp1.val);
                min = Math.min(diff, min);
                temp1 = temp1.right;
            }
            temp = temp.right;
        }
        return min;
    }
    
    // public void solve(TreeNode root, int found){
    //     if(root == null){
    //         return 0;
    //     }
    //     if(root.val < minDiff)
    // }
}