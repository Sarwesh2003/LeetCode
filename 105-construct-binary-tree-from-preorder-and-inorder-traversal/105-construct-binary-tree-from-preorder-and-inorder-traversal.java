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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] idx = new int[]{0};
        TreeNode root = solve(preorder, inorder, idx, 0, preorder.length);
        return root;
    }
    
    public TreeNode solve(int[] pre, int[] in, int[] idx, int inorderS, int inorderE){
        if(idx[0] >= pre.length || inorderS > inorderE){
            return null;
        }
        int element = pre[idx[0]];
        idx[0]++;
        TreeNode root = new TreeNode(element);
        int position = find(in, element, in.length);
        
        root.left = solve(pre, in, idx, inorderS, position - 1);
        root.right = solve(pre, in, idx, position + 1, inorderE);
        
        return root;
    }
    
    public int find(int[] in, int element, int n){
        for(int i=0; i<n; ++i){
            if(in[i] == element)
                return i;
        }
        return -1;
    }
}