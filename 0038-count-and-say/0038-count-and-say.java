class Solution {
    
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        
        
        return solve(n);
        
        
    }
    public String solve(int n){
        if(n == 1)
            return "1";

        StringBuilder ans = new StringBuilder(countAndSay(n - 1));
        StringBuilder res = new StringBuilder();
        int i = 0;
        int len = ans.length();
        
        while(i < len){
            char ch = ans.charAt(i++);
            int count = 1;
            while(i < len && ans.charAt(i) == ch){
                count++;
                i++;
            }
            res.append(count).append(ch);
        }
        return res.toString();
    }
}