//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int i = 0;
        while(i < n){
            int corrIdx = arr[i] - 1;
            if(arr[i] != arr[corrIdx]){
                int temp = arr[i];
                arr[i] = arr[corrIdx];
                arr[corrIdx] = temp;
            }else{
                ++i;
            }
        }
        int[] ans = new int[2];
        for(i = 0; i < n; ++i){
            int corr = i + 1;
            if(arr[i] != corr){
                ans[0] = arr[i];
                ans[1] = corr;
            }
        }
        return ans;
    }
}