//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] weights, int N, int days) {
        int min = Integer.MIN_VALUE, max = 0;
        for(int i : weights){
            min = Math.max(i, min);
            max += i;
        }
        int ans = 0;
        while(min < max){
            int mid = min + (max - min) / 2;
            if(ifPossible(weights, days, mid)){
                ans = mid;
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
    public static boolean ifPossible(int[] arr, int days, int mid){
        int cnt = 1, i = 0;
        int sum = 0;
        while(i < arr.length){
            sum += arr[i];
            if(sum > mid){
                sum = arr[i];
                cnt++;
            }
            ++i;
        }
        
        return cnt <= days ;
    }   
}