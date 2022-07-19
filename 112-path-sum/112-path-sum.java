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
        
        Queue<Integer> sum = new LinkedList<>();
        Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
        sum.add(root.val);
        while(s.size() > 0){
            TreeNode node = s.remove();
            int currSum = sum.remove();
            if(currSum == targetSum && node.right == null && node.left == null){
                return true;
            }
            
            if(node.right != null){
                s.add(node.right);
                sum.add(currSum + node.right.val);
            }
            
            if(node.left != null){
                s.add(node.left);
                sum.add(currSum + node.left.val);
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