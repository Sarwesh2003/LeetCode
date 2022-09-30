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
class Solution {
    static class Comp implements Comparator<ListNode>{
        public int compare(ListNode n1, ListNode n2){
            return n1.val - n2.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0)return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comp());
        
        for(int i = 0; i < k; ++i){
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        ListNode head = null;
        ListNode tail = null;
        while(pq.size() > 0){
            ListNode top = pq.poll();
            if(top.next != null){
                pq.add(top.next);
            }
            
            if(head == null){
                head = top;
                tail = top;
            }else{
                tail.next = top;
                tail = tail.next;
            }
        }
        return head;
    }
}