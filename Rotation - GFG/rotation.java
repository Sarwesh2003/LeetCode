//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // int i = 0;
        // while(i < n-1 && arr[i] < arr[i + 1]){
        //     ++i;
        // }
        // if(i == n - 1){
        //     return 0;
        // }
        // return i + 1;
        int s = 0, e = n - 1, m;
        while(s <= e){
            m = (s + e) >> 1;
            if(m < n - 1 && arr[m] > arr[m + 1]){
                return m + 1;
            }
            if(arr[m] >= arr[0]){
                
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        return 0;
    }
}