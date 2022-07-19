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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        Stack<Integer> sum = new Stack<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        sum.push(root.val);
        while(!s.empty()){
            TreeNode node = s.pop();
            int currSum = sum.pop();
            if(currSum == targetSum && node.right == null && node.left == null){
                return true;
            }
            
            if(node.right != null){
                s.push(node.right);
                sum.push(currSum + node.right.val);
            }
            
            if(node.left != null){
                s.push(node.left);
                sum.push(currSum + node.left.val);
            }
        }
        return false;
        // return Sum(root, targetSum, 0); 
    }
    
    
//     O(2^n)
//     public boolean Sum(TreeNode root, int tgt, int sum){
//         if(root == null) return false;
        
//         sum += root.val;
//         if(tgt == sum && root.left == null && root.right == null)   return true;
        
//         if(Sum(root.left, tgt, sum) || Sum(root.right, tgt, sum)){
//             return true;
//         }
//         return false;
        
//     }
}