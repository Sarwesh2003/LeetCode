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
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int s = 0, m, e = n - 1;
        int pos = -1;
        while(s <= e){
            m = s + (e - s) / 2;
            if(arr[m] == x){
                pos = m;
                break;
            }
            if(arr[m] < x){
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        int count = 0;
        if(pos != -1){
            // count = 1;
            int i = pos - 1;
            while(i >= 0 && arr[i] == arr[pos]){
                --i;
                ++count;
            }
            i = pos;
            while(i < n && arr[i] == arr[pos]){
                ++i;
                ++count;
            }
        }
        return count;
    }
}