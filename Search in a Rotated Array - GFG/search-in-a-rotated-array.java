//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int nums[], int l, int h, int target)
    {
        int p = 0;
        for(int i = 0; i < nums.length - 1; ++i){
            if(nums[i] > nums[i + 1]){
                p = i;
                break;
            }     
        }
        int a = binSearch(nums, target, 0, p);
        int b = binSearch(nums, target, p + 1, nums.length - 1);
        if(a == -1 && b == -1)
        return -1;
        else if(a == -1 && b != -1)
        return b;
        else
        return a;
    }
    public int binSearch(int[] a, int tgt, int s, int e){
        while(s <= e){
            int m = s + (e - s) / 2;
            if(a[m] == tgt){
                return m;
            }
            if(a[m] > tgt){
                e--;
            }else{
                s++;
            }
        }
        return -1;
    }    
}