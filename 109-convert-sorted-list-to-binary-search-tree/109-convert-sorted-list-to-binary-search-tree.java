/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(temp != null){
            list.add(temp.val);
            temp  = temp.next;
        }
        
        
        return solve(list, 0, list.size() - 1);
    }
    public TreeNode solve(ArrayList<Integer> list, int s, int e){
        if(s > e){
            // root = new TreeNode(val);
            return null;
        }
        
        int mid = s + (e - s) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = solve(list, s, mid - 1);
        root.right = solve(list, mid + 1, e);
        // if(root.val > val){
        //     root.left = insertIntoBst(root.left, val);
        // }else{
        //     root.right = insertIntoBst(root.right, val);
        // }
        return root;
    }
}