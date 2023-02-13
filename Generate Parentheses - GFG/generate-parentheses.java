//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans = new ArrayList<>();
        solve(n, ans, new char[2 * n], 0);
        return ans;
        
    }
    public void solve(int n, List<String> list, char[] ch, int pos){
        if(pos == ch.length){
            if(isValid(ch)){
                list.add(new String(ch));
            }
            return;
        }
        ch[pos] = '(';
        solve(n, list, ch, pos + 1);
        ch[pos] = ')';
        solve(n, list, ch, pos + 1);
        return;
    }
    public boolean isValid(char[] arr){
        int bal = 0;
        for(char ch : arr){
            if(ch == '(')bal++;
            else bal--;
            if(bal < 0)return false;
        }
        return bal == 0;
    }
}