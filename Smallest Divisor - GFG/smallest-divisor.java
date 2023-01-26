//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = Integer.MIN_VALUE;
        for(int i : nums){
            // min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int mid = -1;
        int ans = 0;
        while(min <= max){
            mid = min + (max - min) / 2;
            int sum = getSum(nums, mid);
            if(sum <= threshold){
                ans = mid;
                max = mid - 1;
            }else if(sum > threshold){
                min = mid + 1;
            }
        }
        return ans;
    }
    public static int getSum(int[] arr, int div){
        int sum = 0;
        for(int i : arr){
            sum += ((i + div - 1) / div);
        }
        return sum;
    }
}