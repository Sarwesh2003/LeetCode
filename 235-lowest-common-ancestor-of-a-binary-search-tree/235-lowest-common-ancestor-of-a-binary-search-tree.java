/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root, p.val, q.val);
    }
    public TreeNode solve(TreeNode root, int p, int q){
        if(root == null){
            return root;
        }
        if(root.val == p || root.val == q){
            return root;
        }
        
        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);
        
        if(left != null && right != null){
            return root;
        }
        
        if(left != null && right == null){
            return left;
        }
        if(left == null && right != null){
            return right;
        }
        return null;
    }
}