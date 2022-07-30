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
    public TreeNode bstToGst(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list);
        assign(root, list);
        return root;
    }
    public void solve(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        solve(root.left, list);
        list.add(root.val);
        solve(root.right, list);
    }
    public void assign(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        assign(root.left, list);
        assign(root.right, list);
        int sum = 0;
        for(int n : list){
                if(n >= root.val){
                    sum += n;
                }
        }
        root.val = sum;
        
    }
}