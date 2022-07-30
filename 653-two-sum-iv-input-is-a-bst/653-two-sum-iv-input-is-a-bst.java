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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int i = 0, j = list.size() - 1;
        while(i < j){
            int n1 = list.get(i);
            int n2 = list.get(j);
            if((n1 + n2) == k){
                return true;
            }
            if((n1 + n2) > k){
                --j;
            }else{
                ++i;
            }
        }
        return false;
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