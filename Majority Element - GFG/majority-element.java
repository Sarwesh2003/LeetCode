//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int size)
    {
        if(size == 1)
            return nums[0];
        Arrays.sort(nums);

        int num = nums[0];
        int count = 1;
        for(int i = 1; i < size; ++i){
            if(num == nums[i]){
                count++;
            }else{
                if(count > (size / 2)){
                    return num;
                }
                num = nums[i];
                count = 1;
            }
        }
        if(count > (size/2))
            return num;
        return -1;
    }
}