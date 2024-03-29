//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        int s = 0, m = 0, e = arr.length - 1;
        int p = 0;
        if(n == 1)
        return arr[0];
        if(arr[s] < arr[e]){
            return arr[s];
        }
        int min = Integer.MAX_VALUE;
        while(s <= e){
            if(arr[s] < arr[e]){
                min = Math.min(min, arr[s]);
                return min;
            }
            m = s + (e - s) / 2;
            if(arr[s] <= arr[m]){
                min = Math.min(min, arr[s]);
                s = m + 1;
            }else{
                min = Math.min(min, arr[m]);
                e = m - 1;
            }
        }
        return min;
    }
}
