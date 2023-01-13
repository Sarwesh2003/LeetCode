//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int nums[], int n)
    {
        int r = 0, b = 0, w = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                r++;
            }else if(nums[i] == 1){
                w++;
            }else{
                b++;
            }
        }
        for(int i = 0; i < nums.length; ++i){
            if(r > 0){
                nums[i] = 0;
                r--;
            }else if(w > 0){
                nums[i] = 1;
                w--;
            }else if(b > 0){
                nums[i] = 2;
                b--;
            }
        }
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends