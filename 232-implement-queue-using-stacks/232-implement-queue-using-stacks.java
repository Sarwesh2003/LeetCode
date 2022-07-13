class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int rear;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        rear = -1;
    }
    private void shift(){
        while(!s1.empty()){
            s2.push(s1.pop());
        }
    }
    public void push(int x) {
        rear++;
        s1.push(x);
        // shift();
        // reverse(s1, x);
    }
    private void reverse(Stack<Integer> s,int n){
        if(s.empty()){
            s.add(n);
            return;
        }
        int num = s.peek();
        s.pop();
        reverse(s, n);
        s.push(num);
    }
    public int pop() {
        if(s2.empty()){
            shift();
            rear--;
            return s2.pop();
        }
        int x = s2.pop();
        rear--;
        return x;
    }
    
  
    public int peek() {
        if(s2.empty()){
            shift();
            return s2.peek();
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return rear == -1;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */