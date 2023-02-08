//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        if(head == null)return head;
        Node rev = reverseList(head);
        Node temp = rev;
        int carr = 1;
        while(temp != null){
            if(temp.data + carr <= 9){
                temp.data = temp.data + 1;
                break;
            }else if(temp.data + carr > 9 && temp.next == null){
                temp.data = 0;
                temp.next = new Node(1);
                break;
            }else{
                temp.data = 0;
                carr = 1;
            }
            temp = temp.next;
        }
        return reverseList(rev);
        // return head;
    }
    public static Node reverseList(Node head){
        Node curr = head;
        Node prev = null;
        Node fr = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = fr;
            if(fr != null)
                fr = fr.next;
        }
        return prev;
    }
}
