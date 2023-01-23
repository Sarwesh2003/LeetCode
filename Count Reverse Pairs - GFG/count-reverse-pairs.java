//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countRevPairs(int N, int arr[]) {
        int[] temp = new int[N];
        return mergeSort(arr, temp, 0, N - 1);
    }
    public int mergeSort(int[] a, int[] temp, int low, int high){
        if(low >= high){
            return 0;
        }
        int ans = 0;
            int m = low + (high - low) / 2;
            ans += mergeSort(a, temp, low, m);
            ans += mergeSort(a, temp, m + 1, high);
            
            ans += merge(a, temp, low, m, high);
        return ans;
    }
    public int merge(int[] a, int[] temp, int low, int m, int high){
        int count = 0;
        int j = m + 1;
        for(int i = low; i <= m; ++i){
            while(j <= high && a[i] > (2 * a[j]))++j;
            
            count += (j - (m + 1));
        }
        int i = low, k = low;
        j = m + 1;
        
        while(i <= m && j <= high){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        while(i <= m){
            temp[k++] = a[i++];
        }
        while(j <= high){
            temp[k++] = a[j++];
        }
        for(i = low; i <= high; ++i){
            a[i] = temp[i];
        }
        return count;
    }
}