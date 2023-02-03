//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLen, start;
    static String longestPalin(String s){
        int n = s.length();
        maxLen = 0;
        start = 0;
        for(int i = 0; i < n; ++i){
            extendedPallindrome(s, i, i, n);
            extendedPallindrome(s, i, i + 1, n);
        
        }
        return s.substring(start, start + maxLen);
    }
    public static void extendedPallindrome(String str, int i, int j, int n){
        while(i >= 0 && j < n && str.charAt(i) == str.charAt(j)){
            --i;
            ++j;
        }
        if(j - i- 1 > maxLen){
            start = i + 1;
            maxLen = j - i - 1;
        }
    }
}