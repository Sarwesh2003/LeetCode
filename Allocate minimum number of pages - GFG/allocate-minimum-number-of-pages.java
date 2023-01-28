//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M > N)
        return -1;
        int min = Integer.MAX_VALUE, max = 0;
        for(int a : A){
            min = Math.min(min, a);
            max += a;
        }
        int res = -1;
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(ifPossible(A, M, mid)){
                res = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return res;
    }
    public static boolean ifPossible(int[] arr, int m, int mid){
        int stud = 1;
        int curr = 0;
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] > mid){
                return false;
            }
            if((curr + arr[i]) > mid){
                stud++;
                curr = arr[i];
            }else{
                curr += arr[i];
            }
        }
        // if(curr <= mid){
        //     stud++;
        // }
        if(stud > m){
            return false;
        }
        return true;
    }
};