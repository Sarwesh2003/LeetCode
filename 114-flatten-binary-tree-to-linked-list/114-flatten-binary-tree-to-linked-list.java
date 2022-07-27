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
    public void flatten(TreeNode root) {
//         ArrayList<Integer> list = new ArrayList<>();
//         preorder(root, list);
        
//         TreeNode r = root;
//         for(int i=1; i<list.size(); ++i){
//             r.right = new TreeNode(list.get(i));
//             r.left = null;
//             r = r.right;
//         }
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode p = curr.left;
                while(p.right != null){
                    p = p.right;
                }
                p.right = curr.right;
                curr.right = curr.left;
            }
            curr.left = null;
            curr = curr.right;
        }
    }
    
//  O(N) aopproach   
    public void preorder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}