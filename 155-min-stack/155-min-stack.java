class MinStack {
    Stack<Long> s;
    long top;
    long min;
    public MinStack() {
        s = new Stack<>();
        top = -1;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        long val = value;
        if(s.empty()){
            s.push(val);
            top++;
            min = val;
            return;
        }
        if(val < min){
            long newVal = (2 * val) - min;
            min = val;
            s.push(newVal);
            top++;
        }else{
            s.push(val); 
            top++;
            min = min < val?min:val;
        }
    }
    
    public void pop() {
        if(top != -1){
            long element = s.peek();
            s.pop();
            top--;
            if(element < min){
                min = (2 * min) - element;
            }
        }
    }
    
    public int top() {
        long element = s.peek();
        if(s.peek() < min){
            return (int)min;
        }else{
            return (int)element;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */