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
    ArrayList<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        // solve(root);
        morrisTraversal(root, list);
        return list;
        // return list;
    }
    
    public void solve(TreeNode root){
        if(root == null){
            return;
        }
        solve(root.left);
        list.add(root.val);
        solve(root.right);
    }
    public void morrisTraversal(TreeNode root, List<Integer> list){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    pred.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}