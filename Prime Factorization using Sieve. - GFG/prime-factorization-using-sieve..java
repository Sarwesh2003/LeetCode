//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static List<Integer> ans;
    static int n;
    // You must implement this function
    static void sieve() {
        boolean[] map = new boolean[n + 1];
        Arrays.fill(map, true);
        for(int i = 2; i * i <= n; ++i){
            if(map[i]){
                if(n % i == 0){
                    // ans.add(i);
                    while(n % i == 0){
                        n /= i;
                        ans.add(i);
                    }
                }
            }
            for(int j = i + i; j < n; j += i){
                map[j] = false;
            }
        }
        if(n > 1){
            ans.add(n);
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        ans = new ArrayList<>();
        n = N;
        sieve();
        return ans;
        
    }
}
