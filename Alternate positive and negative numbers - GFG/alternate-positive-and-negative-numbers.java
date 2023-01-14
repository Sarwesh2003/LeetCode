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

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int nums[], int n) {
        int[] pos = new int[n];
        int[] neg = new int[n];
        int p = 0, ng = 0;
        for(int i = 0; i < n; ++i){
            if(nums[i] < 0){
                neg[ng++] = nums[i];
            }else{
                pos[p++] = nums[i];
            }
        }
        // p = ng = 0;
        int j = 0, k = 0, i;
        for(i = 0; i < n; ++i){
            if(i % 2 == 0 && j <= p){
                nums[i] = pos[j++];
            }else if(i % 2 != 0 && k <= ng){
                nums[i] = neg[k++];
            }
            if(j > p || k > ng){
                break;
            }
        }
        if(j < p){
            while(i < n){
                nums[i++] = pos[j++];
            }
        }else if(k < ng){
            while(i < n){
                nums[i++] = neg[k++];
            }
        }
    }
}