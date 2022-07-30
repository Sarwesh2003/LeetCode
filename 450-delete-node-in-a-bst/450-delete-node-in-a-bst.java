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
    public TreeNode deleteNode(TreeNode root, int key) {
        root = solve(root, key);
        return root;
    }
    
    public TreeNode solve(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null && root.right != null){
                return root.right;
            }
            if(root.left != null && root.right == null){
                return root.left;
            }
            if(root.left != null && root.right != null){
                root.val = findMax(root.left);
                root.left = solve(root.left, root.val);
                return root;
            }
        }
        root.left = solve(root.left, key);
        root.right = solve(root.right, key);
        return root;
    }
    
    public int findMax(TreeNode root){
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.val;
    }
}