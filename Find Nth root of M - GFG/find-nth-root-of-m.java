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
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        int s = 0, mid, e = m;
        int ans = -1;
        while(s <= e){
            mid = (s + e) >> 1;
            int p = (int)Math.pow(mid, n);
            if(p == m){
                return mid;
            }
            if(p < m){
                // ans = mid;
                s = mid + 1;
            }else{
                // ans = mid;
                e = mid - 1;
            }
        }
        return ans;
    }
}