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

class Custom{
    TreeNode node;
    int hd;
    int level;
    public Custom(TreeNode _node, int _hd, int _level){
        this.node = _node;
        this.hd = _hd;
        this.level = _level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
        Queue<Custom> q = new LinkedList<>();
        
        q.add(new Custom(root, 0, 0));
        
        while(q.size() > 0){
            Custom cn = q.remove();
            TreeNode node = cn.node;
            int level = cn.level;
            int hd = cn.hd;
            
            if(!map.containsKey(hd)){
                map.put(hd, new TreeMap<>());
            }
            if(!map.get(hd).containsKey(level)){
                map.get(hd).put(level, new PriorityQueue<>());
            }
            
            map.get(hd).get(level).add(node.val);
            
            if(node.left != null){
                q.add(new Custom(node.left, hd - 1, level + 1));
            }
            if(node.right != null){
                q.add(new Custom(node.right, hd + 1, level + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> outer:map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> inner:outer.values()){
                // for(int value : inner){
                //     ans.add(value);
                // }
                // ans.add(inner);
                while(!inner.isEmpty()){
                    ans.get(ans.size() - 1).add(inner.poll());
                }
                
            }
        }
        return ans;
    }
}