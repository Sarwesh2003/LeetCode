//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int m, int k, int[] bloomDay) {
       long pos = (m * k) ;
        if(pos > bloomDay.length){
            return -1;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i : bloomDay){
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int mid = -1;
        int ans = -1;
        while(min <= max){
            mid = min + (max - min) / 2;
            if(isPossible(bloomDay, mid, k, m)){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] arr, int mid, int k, int m){
        int mm = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] <= mid){
                cnt++;
            } else{
                cnt = 0;
            }
            if(cnt >= k){
                ++mm;
                cnt = 0;
            }
        }
        return mm >= m;
    }
    
}