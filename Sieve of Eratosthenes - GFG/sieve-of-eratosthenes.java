//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
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
            if(!vis[i])ans.add(i);
        }
        return ans;
    }
}