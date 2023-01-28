//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int maxDiff = stalls[n - 1] - stalls[0];
        int ans = Integer.MIN_VALUE;
        int s = 1, e = maxDiff;
        while(s <= e){
            int m = s + (e - s) / 2;
            if(isPossible(stalls, n, k, m)){
                ans = m;
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] arr, int n, int k, int d){
        int curr = arr[0];
        k--;
        for(int i = 1; i < n; ++i){
            if(arr[i] - curr >= d){
                k--;
                if(k == 0){
                    return true;
                }
                curr = arr[i];
            }
        }
        return false;
    }
}