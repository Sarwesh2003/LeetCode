//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        // Arrays.sort(arr);
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MIN_VALUE;
        // for(int i : arr){
        //     if(max < i){
        //         min = max;
        //         max = i;
        //     }
        // }
        // if(min != Integer.MIN_VALUE){
        //     return min;
        // }
        
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        
        for(int i : arr){
            if(max < i){
                max = i;
            }
        }
        for(int i : arr){
            if(smax < i && i != max){
                smax = i;
            }
        }
        if(smax != Integer.MIN_VALUE)
            return smax;
        return -1;
    }
}