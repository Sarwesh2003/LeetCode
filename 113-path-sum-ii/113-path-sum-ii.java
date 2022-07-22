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
    int sum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        solve(root, targetSum, list1, list);
        return list;
    }
    
    public void solve(TreeNode root, int tgt, List<Integer> list,List<List<Integer>> ans){
        if(root == null){
            return;
        }
        
        sum += root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && tgt == sum){
                
            ans.add(new ArrayList<>(list));
            // System.out.println(ans);
        }
        
        solve(root.left, tgt, list, ans);
        solve(root.right, tgt, list, ans);
        sum -= root.val;
        
        // ans.add(list);
        list.remove(list.size() - 1);
        return;
    }
}