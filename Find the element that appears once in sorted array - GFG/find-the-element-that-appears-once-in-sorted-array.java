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
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // int xor = 0;
        // for(int n : nums){
        //     xor ^= n;
        // }
        // return xor;
        int s = 0, mid = 0, e = n - 1;
        while(s < e){
            mid = s + (e - s) / 2;
            if(mid % 2 == 0){
                if(arr[mid] == arr[mid + 1]){
                    s = mid + 2;
                }else{
                    e = mid;    
                }
            }else if(mid % 2 != 0){
                if(arr[mid] == arr[mid - 1]){
                    s = mid + 1;
                }else{
                    e = mid - 1;
                }
            }
        }
        return arr[s];
    }
}