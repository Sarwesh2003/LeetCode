class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = solve(n);
        return ans;
    }
    
    public List<String> solve(int n){
        if(n == 1){
            List<String> ans = new ArrayList<String>();
            ans.add("()");
            return ans;
        }
        
        List<String> res = solve(n - 1);
        List<String> ans = new ArrayList<>();
        for(String temp : res){
            for(int i = 0; i < temp.length(); ++i){
                String newStr = temp.substring(0,i) + "()" + temp.substring(i);
                if(!ans.contains(newStr) && isValid(newStr)){
                    ans.add(newStr);
                }
            }
        }
        return ans;
    }
    
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '('){
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
}