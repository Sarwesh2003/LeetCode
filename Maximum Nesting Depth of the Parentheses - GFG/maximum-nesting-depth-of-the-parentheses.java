//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        if(n == 1 && s.charAt(0) != '(' && s.charAt(0) != ')'){
            return 0;
        }
        int closing = 0, opening = 0;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                opening++;
            }else if(ch == ')'){
                closing++;
            }
            max = Math.max(max, (opening - closing));
        }
        return max;
    }
}