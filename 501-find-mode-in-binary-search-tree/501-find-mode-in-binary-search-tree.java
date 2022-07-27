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
    int count = 0;
    public int[] findMode(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        solve(root, map);
        int max = Integer.MIN_VALUE;
        for(int element : map.values()){
            max = Math.max(element, max);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for(int element : list){
            ans[i] = element;
            ++i;
        }
        
        return ans;
    }
    public void solve(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        solve(root.left, map);
        solve(root.right, map);
    }
}