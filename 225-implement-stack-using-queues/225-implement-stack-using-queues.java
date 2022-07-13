class MyStack {
    Queue<Integer> q1;
    int size;
    int top;
    public MyStack() {
        q1 = new LinkedList<>();
        top = -1;
        size = 0;
    }
    
    public void push(int x) {
        q1.add(x);
        for(int i=0; i<size; ++i)
            q1.add(q1.remove());
        top++;
        size++;
    }
    
    public int pop() {
        if(!empty()){
            top--;
            size--;
            return q1.remove();
        }
        return -1;
    }
    
    public int top() {
        if(!empty())
            return q1.peek();
        return -1;
    }
    
    public boolean empty() {
        return top == -1;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */