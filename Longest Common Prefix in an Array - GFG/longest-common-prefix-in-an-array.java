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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        int s = 0, e = Integer.MAX_VALUE;
        for(String str : arr){
            e = Math.min(e, str.length());
        }
        while(s <= e){
            int mid = (s + e) >> 1;
            if(isPossible(arr, mid)){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        String ans = arr[0].substring(0, e);
        if(ans.isEmpty()){
            return "-1";
        }
        return ans;
    }
    public boolean isPossible(String[] arr, int mid){
        String temp = arr[0].substring(0, mid);
        for(int i = 1; i < arr.length; ++i){
            if(!arr[i].startsWith(temp)){
                return false;
            }
        }
        return true;
    }
}