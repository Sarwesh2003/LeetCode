class Solution {
    public List<String> generateParenthesis(int n) {
        // Bruteforce
        // List<String> ans = bruteforce(n);
        List<String> ans = new ArrayList<>();
        optimized(ans, 0, 0, new StringBuilder(), n);
        return ans;
    }
    
    public void optimized(List<String> ans, int left, int right, StringBuilder s, int n){
        if(s.length() == (2 * n)){
            ans.add(s.toString());
            return;
        }
        
        
        if(left < n){
            s.append('(');
            optimized(ans, left + 1, right, s, n);
            s.delete(s.length() - 1, s.length());
        }
        
        if(right < left){
            s.append(')');
            optimized(ans, left, right + 1, s, n);
            s.delete(s.length() - 1, s.length());
        }
        
    }
    
    public List<String> bruteforce(int n){
        if(n == 1){
            List<String> ans = new ArrayList<String>();
            ans.add("()");
            return ans;
        }
        
        List<String> res = bruteforce(n - 1);
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
        // int i = 0;
        for(char ch : str.toCharArray()){
            if(ch == '('){
                s.push(ch);
            }else{
                if(s.empty()){
                    return false;
                }else if(ch == ')'&& s.peek() == '('){
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