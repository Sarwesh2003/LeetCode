class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        // s1.push(x);
        // shift();
        reverse(s1, x);
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
        if(!empty()){
            return s1.pop();
        }
        return -1;
    }
    
  
    public int peek() {
        if(!empty()){
            return s1.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        return s1.empty();
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