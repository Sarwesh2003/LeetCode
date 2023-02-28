//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        ArrayList<Integer> list = sieveOfEratosthenes(N);
        // ArrayList<Integer> ansList = new ArrayList<Integer>();
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); ++i){
            ans[i] = list.get(i);
        }
        return ans;
        
    }
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        if(n <= 1)return ans;
        boolean[] vis = new boolean[n + 1];
        Arrays.fill(vis, false);
        vis[0] = true;
        vis[1] = true;
        for(int i = 2; i <= n; ++i){
            if(!vis[i]){
                int j = i + i;
                while(j <= n){
                    vis[j] = true;
                    j += i;
                }
            }
        }
        
        for(int i = 1; i <= n; ++i){
            if(!vis[i] && (n % i == 0))ans.add(i);
        }
        return ans;
    }
}