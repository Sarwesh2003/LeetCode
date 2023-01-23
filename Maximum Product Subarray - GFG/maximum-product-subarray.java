//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] nums, int j) {
        long prod = 1;
        boolean zero = false;
        long ml, mr;
        ml = mr = Integer.MIN_VALUE;
        for(int n : nums){
            prod *= n;
            if(n == 0){
                zero = true;
                prod = 1;
                continue;
            }
            ml = Math.max(ml, prod);
        }
        prod = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            prod *= nums[i];
            if(nums[i] == 0){
                zero = true;
                prod = 1;
                continue;
            }
            mr = Math.max(mr, prod);
        }
        if(zero)
            return (long)Math.max(Math.max(mr, ml), 0);
        return (long)Math.max(mr, ml);
    }
}