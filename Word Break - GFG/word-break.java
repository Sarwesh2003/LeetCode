//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        boolean[] dp = new boolean[A.length()];
        return solve(new StringBuilder(A), 0, B, dp)? 1 : 0;
    }
    public static boolean solve(StringBuilder s, int idx, ArrayList<String> wd, boolean[] dp){
        if(idx == s.length())return true;

        if(dp[idx] != false)return dp[idx];
        for(int i = idx + 1; i <= s.length(); ++i){
            if(wd.contains(s.substring(idx, i)) && solve(s, i, wd, dp)){
                dp[idx] = true;
                return dp[idx];
            }
        }
        dp[idx] = false;
        return dp[idx];
        // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
        // ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

    }
}