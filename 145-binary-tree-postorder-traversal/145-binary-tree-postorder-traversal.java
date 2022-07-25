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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // solve(root, list);
        morrisTraversal(root, list);
        return list;
    }
    
    public void morrisTraversal(TreeNode root, List<Integer> list){
        TreeNode curr = root;
        while(curr != null){
            if(curr.right == null){
                list.add(curr.val);
                curr = curr.left;
            }else{
                TreeNode pred = curr.right;
                
                while(pred.left != null && pred.left != curr){
                    pred = pred.left;
                }
                if(pred.left == null){
                    list.add(curr.val);
                    pred.left = curr;
                    curr = curr.right;
                }else{
                    pred.left = null;
                    // list.add(curr.val);
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(list);
    }
    
    public TreeNode predecesor(TreeNode root, TreeNode curr){
        TreeNode temp = root;
        while(temp.right != null && temp.right != curr){
            temp = temp.right;
        }
        return temp;
    }
    
    
    
    // TC: O(N) SC: O(N)
    public void solve(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        solve(root.left, list);
        solve(root.right, list);
        list.add(root.val);
    }
}