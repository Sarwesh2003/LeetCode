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
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        int diff = Integer.MAX_VALUE;
        int prev = -1;
        TreeNode temp = root;
        
        while(temp != null){
            if(temp.left == null){
                if(prev != -1){
                    diff = Math.min(temp.val - prev, diff);
                }
                prev = temp.val;
                temp = temp.right;
            }else{
                TreeNode pred = temp.left;
                while(pred.right != null && pred.right != temp){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = temp;
                    temp = temp.left;
                }else{
                    pred.right = null;
                    if(prev != -1){
                        diff = Math.min(temp.val - prev, diff);
                    }
                    prev = temp.val;
                    temp = temp.right;
                }
            }
        }
        return diff;
    }
    
}