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
    int maxi = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        solve(root);
        if(maxi == Integer.MIN_VALUE)
            return 0;
        return maxi;
    }
    
    public Valid solve(TreeNode root){
        if(root == null){
            return new Valid(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Valid left = solve(root.left);
        Valid right = solve(root.right);
        
        
        int max = Math.max(root.val, right.max);
        int min = Math.min(root.val, left.min);
        boolean valid = false;
        int sum = 0;
        if(left.valid && right.valid && root.val > left.max && root.val < right.min){
            valid = true;
            sum = root.val + left.sum + right.sum;
        }else{
            valid = false;
            // sum -= root.val;
        }
        if(valid && sum >= 0){
            maxi = Math.max(sum, maxi); 
        }
        return new Valid(valid, max, min, sum);
    }
}

class Valid{
    boolean valid;
    int max, min;
    int sum;
    public Valid(boolean _valid, int _max, int _min, int _sum){
        this.valid = _valid;
        this.max = _max;
        this.min = _min;
        this.sum = _sum;
    }
}