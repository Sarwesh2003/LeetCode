//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> ans = new ArrayList<>();
        int pow = (int)Math.pow(2, s.length());
        for(int i = 0; i < pow; ++i){
             String str = "";
             for(int j = 0; j < s.length(); ++j){
                 if((i & (1 << j)) != 0){
                     str += s.charAt(j);
                 }
             }
             if(str != "")
                ans.add(str);
        }
        Collections.sort(ans);
        return ans;
    }
    public void solve(String s, int idx, StringBuilder curr, int k, List<String> ans){
        if(curr.length() == k && curr.length() > 0){
            ans.add(curr.toString());
            
            return;
        }
        for(int i = idx; i < s.length(); ++i){
            curr.append(s.charAt(i));
            solve(s, i + 1, curr, k, ans);
            curr.delete(curr.length() - 1, curr.length());
        }
    }
}