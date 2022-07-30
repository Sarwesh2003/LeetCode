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
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length <= 0)
            return null;
        i = 0;
        TreeNode root = solve(preorder, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    
    public TreeNode solve(int[] pre, int n, int min, int max){
        if(i >= n){
            return null;
        }
        int element = pre[i];
        if(element < min || element > max){
            return null;
        }
        ++i;
        TreeNode root = new TreeNode(element);
        root.left = solve(pre, n, min, root.val);
        root.right = solve(pre, n, root.val, max);
        return root;
    }
}