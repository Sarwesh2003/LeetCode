//{ Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends


class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    StackNode head;
    public MyStack(){
        head = top;
    }
    //Function to push an integer into the stack.
    void push(int a) 
    {
        if(top == null){
            top = new StackNode(a);
            head = top;
        }else{
            top.next = new StackNode(a);
            top = top.next;
        }
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        if(top == null)return -1;
        
        int element = top.data;
        
        StackNode temp = head;
        if(temp == top){
            top = null;
            return element;
        }
        while(temp.next != top){
            temp = temp.next;
        }
        top = temp;
        top.next = null;
        return element;
    }
}
