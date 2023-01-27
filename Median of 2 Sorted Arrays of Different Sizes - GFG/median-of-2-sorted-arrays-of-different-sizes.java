//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int l, int k, int nums1[], int nums2[]) 
    {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, idx = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                merged[idx++] = nums1[i];
                ++i;
            }else{
                merged[idx++] = nums2[j];
                ++j;
            }
        }
        while(i < m){
            merged[idx++] = nums1[i++];
        }
        while(j < n){
            merged[idx++] = nums2[j++];
        }
        if((m + n) % 2 == 0){
            return (merged[(m + n) / 2] + merged[((m + n) / 2) - 1]) / 2.0;
        }else{
            return ((double)merged[(m + n) / 2]);
        }
    }
}