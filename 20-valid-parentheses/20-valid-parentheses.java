class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()){
            if(isOpening(ch)){
                s.push(ch);
            }else{
                if(s.empty()){
                    return false;
                }
                if(ch == ']' && s.peek() == '['){
                    s.pop();
                }else if(ch == ')'&& s.peek() == '('){
                    s.pop();
                }else if(ch == '}' && s.peek() == '{'){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.empty()){
            return true;
        }
        return false;
    }
    private boolean isOpening(char ch){
        return ch == '(' || ch == '{' || ch == '[';
    }
   
}