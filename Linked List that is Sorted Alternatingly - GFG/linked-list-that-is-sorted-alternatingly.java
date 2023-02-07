//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
   public Node sort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node left = sort(head);
        Node right = sort(mid);
        return merge(left, right);
   }
    public Node merge(Node h1, Node h2){
        Node ans = new Node(-1);
        Node tail = ans;
        while(h1 != null && h2 != null){
            if(h1.data < h2.data){
                tail.next = h1;
                h1 = h1.next;
            }else{
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        tail.next = h1 == null ? h2 : h1;
        return ans.next;
    }
    public Node getMid(Node head){
        Node slow = null;
        while(head != null && head.next != null){
            slow = slow != null ? slow.next : head;
            head = head.next.next;
        }
        
        Node mid = slow.next;
        slow.next = null;
        return mid;
    }


}