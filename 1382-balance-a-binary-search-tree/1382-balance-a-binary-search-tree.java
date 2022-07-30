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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return null;
        
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        root = create(list, 0, list.size() - 1);
        return root;
    }
    public TreeNode create(ArrayList<Integer> list, int s, int e){
        if(s > e){
            return null;
        }
        
        int mid = s + (e - s) / 2;
        int element = list.get(mid);
        TreeNode root = new TreeNode(element);
        root.left = create(list, s, mid - 1);
        root.right = create(list, mid + 1, e);
        return root;
    }
    
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null)
            return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
}