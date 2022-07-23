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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        mapPos(inorder, map, inorder.length);
        TreeNode root = solve(preorder, inorder, 0, preorder.length, map);
        return root;
    }
    
    public TreeNode solve(int[] pre, int[] in, int inorderS, int inorderE, HashMap<Integer, Integer> map){
        if(idx >= pre.length || inorderS > inorderE){
            return null;
        }
        int element = pre[idx++];
        TreeNode root = new TreeNode(element);
        int position = map.get(element);
        
        root.left = solve(pre, in, inorderS, position - 1, map);
        root.right = solve(pre, in, position + 1, inorderE, map);
        
        return root;
    }
    
    public void mapPos(int[] in, HashMap<Integer, Integer> map,int n){
        for(int i=0; i<n; ++i){
            map.put(in[i], i);
        }
    }
}