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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        if(len == 1){
            head = null;
            return head;
        }
        ListNode temp = head;
        int cnt = len - n;
        ListNode prev = null;
        if(cnt == 0){
            return head.next;
        }
        while(cnt-- > 0){
            prev=temp;
            temp = temp.next;
        }
        prev.next=temp.next;
        return head;
    }
    
    public int getLength(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}