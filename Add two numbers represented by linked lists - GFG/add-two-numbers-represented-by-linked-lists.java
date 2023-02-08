//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        if(first == null || second == null){
            return first == null ? second : first;
        }
        Node f = revList(first);
        Node s = revList(second);
        Node ansH = new Node(-1);
        Node ans = ansH;
        int carr = 0;
        while(f != null || s != null || carr == 1){
            int sum = 0;
            if(f != null){
                sum += f.data;
                f = f.next;
            }
            if(s != null){
                sum += s.data;
                s = s.next;
            }
            sum += carr;
            Node c = new Node(sum % 10);
            ans.next = c;
            ans = ans.next;
            carr = sum /10;
        }
        return revList(ansH.next);
    }
    static Node revList(Node head){
        Node prev = null;
        Node curr = head;
        Node fr = null;
        
        while(curr != null){
            fr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fr;
        }
        return prev;
    }
}