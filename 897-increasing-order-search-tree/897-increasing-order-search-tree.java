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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        root.val = list.get(0);
        TreeNode temp = root;
        for(int i=1; i<list.size(); ++i){
            temp.right = new TreeNode(list.get(i));
            temp.left = null;
            temp = temp.right;
        }
        return root;
    }
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}